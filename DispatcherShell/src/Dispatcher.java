public class Dispatcher implements IDispatcher {
	private IProcessor processor;
	private IProcessReader processReader;
	private IOutput output;
	private IProcessQueue realTimeQueue;
	private IProcessQueue highestQueue;
	private IProcessQueue mediumQueue;
	private IProcessQueue lowestQueue;
	private int currentTime;

	public Dispatcher(IProcessor processor, IProcessReader processReader, IOutput output) throws Exception {

		if (processor == null)
			throw new Exception("Dispatcher oluşturulurken processor değişkenine NULL gönderildi!");
		else if (processReader == null)
			throw new Exception("Dispatcher oluşturulurken processReader değişkenine NULL gönderildi!");
		else if (output == null)
			throw new Exception("Dispatcher oluşturulurken output değişkenine NULL gönderildi!");

		this.processor = processor;
		this.processReader = processReader;
		this.output = output;
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
		Node<ISpecialProcess>[] deletedProcesses;

		deletedProcesses = realTimeQueue.search(currentTime - 20);
		for (Node<ISpecialProcess> node : deletedProcesses) {
			node.data.setStatement(Statement.TimeOut);
			output.processTimeOut(node.data, currentTime);
			realTimeQueue.delete(node);
		}

		deletedProcesses = highestQueue.search(currentTime - 20);
		for (Node<ISpecialProcess> node : deletedProcesses) {
			node.data.setStatement(Statement.TimeOut);
			output.processTimeOut(node.data, currentTime);
			highestQueue.delete(node);
		}

		deletedProcesses = mediumQueue.search(currentTime - 20);
		for (Node<ISpecialProcess> node : deletedProcesses) {
			node.data.setStatement(Statement.TimeOut);
			output.processTimeOut(node.data, currentTime);
			mediumQueue.delete(node);
		}

		deletedProcesses = lowestQueue.search(currentTime - 20);
		for (Node<ISpecialProcess> node : deletedProcesses) {
			node.data.setStatement(Statement.TimeOut);
			output.processTimeOut(node.data, currentTime);
			lowestQueue.delete(node);
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