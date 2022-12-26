public class Dispatcher implements IDispatcher {
	private IProcessor processor;
	private IProcessReader processReader;
	private IProcessQueue realTimeQueue;
	private IProcessQueue highestQueue;
	private IProcessQueue mediumQueue;
	private IProcessQueue lowestQueue;
	private int currentTime;

	public Dispatcher(IProcessor processor, IProcessReader processReader) throws Exception {

		if (processor == null)
			throw new Exception("Dispatcher oluşturulurken processor değişkenine NULL gönderildi!");
		else if (processReader == null)
			throw new Exception("Dispatcher oluşturulurken processReader değişkenine NULL gönderildi!");

		this.processor = processor;
		this.processReader = processReader;
		this.currentTime = 0;
		this.realTimeQueue = new ProcessQueue(Priority.RealTime);
		this.highestQueue = new ProcessQueue(Priority.Highest);
		this.mediumQueue = new ProcessQueue(Priority.Medium);
		this.lowestQueue = new ProcessQueue(Priority.Lowest);
	}

	private ISpecialProcess getAppropriateProcess() {
		if (!realTimeQueue.isEmpty())
			return realTimeQueue.dequeue();
		else if (!highestQueue.isEmpty())
			return highestQueue.dequeue();
		else if (!mediumQueue.isEmpty())
			return mediumQueue.dequeue();
		else if (!lowestQueue.isEmpty())
			return lowestQueue.dequeue();
		else
			return null;
	}

	private void queueProcess(ISpecialProcess process) {
		if (process.getPriority() == Priority.RealTime)
			realTimeQueue.enqueue(process);
		else if (process.getPriority() == Priority.Highest)
			highestQueue.enqueue(process);
		else if (process.getPriority() == Priority.Medium)
			mediumQueue.enqueue(process);
		else // (process.getPriority()==Priority.Lowest)
			lowestQueue.enqueue(process);
	}

	private void terminateTimeOut() {
		ISpecialProcess[] deletedProcesses;

		deletedProcesses = realTimeQueue.search(currentTime - 20);
		for (var process : deletedProcesses) {
			process.setStatement(Statement.TimeOut);
			System.out.println(currentTime + " sn proses zaman aşımı	(id: " + "	öncelik:" + "	kalan süre:" + " sn)");
			realTimeQueue.delete(process);
		}

		deletedProcesses = highestQueue.search(currentTime - 20);
		for (var process : deletedProcesses) {
			process.setStatement(Statement.TimeOut);
			System.out.println(currentTime + " sn proses zaman aşımı	(id: " + "	öncelik:" + "	kalan süre:" + " sn)");
			highestQueue.delete(process);
		}

		deletedProcesses = mediumQueue.search(currentTime - 20);
		for (var process : deletedProcesses) {
			process.setStatement(Statement.TimeOut);
			System.out.println(currentTime + " sn proses zaman aşımı	(id: " + "	öncelik:" + "	kalan süre:" + " sn)");
			mediumQueue.delete(process);
		}

		deletedProcesses = lowestQueue.search(currentTime - 20);
		for (var process : deletedProcesses) {
			process.setStatement(Statement.TimeOut);
			System.out.println(currentTime + " sn proses zaman aşımı	(id: " + "	öncelik:" + "	kalan süre:" + " sn)");
			lowestQueue.delete(process);
		}
	}

	@Override
	public void start() {
		while (true) {
			terminateTimeOut();
			IProcessQueue receivedProcesses = processReader.getProcesses(currentTime);
			ISpecialProcess process;
			while (!receivedProcesses.isEmpty()) {
				process = receivedProcesses.dequeue();
				process.setStatement(Statement.Ready);
				queueProcess(process);
			}
			process = getAppropriateProcess();

			if (process == null)
				break;

			process.setStatement(Statement.Running);
			processor.run(process, currentTime);

			if (process.getBurstTime() == 0)
				process.setStatement(Statement.Terminated);
			else {
				process.setStatement(Statement.Ready);
				queueProcess(process);
			}
			++currentTime;
		}
		System.out.println("\nBütün prosesler listelendi.");
	}

}