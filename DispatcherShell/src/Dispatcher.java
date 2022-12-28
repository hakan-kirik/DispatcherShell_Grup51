// Başlık:		Dispatcher
// Açıklama:	Görevlendiriciyi simüle eden sınıf
// Ders Adı:	İşletim Sistemleri
// Konu:		Görevlendirici Kabuğu Proje Ödevi
// Grup:		51
// Öğrenciler:	Hakan Kırık(B201210370) - Yasin Emin Esen(B211210386) - Apltekin Ocakdan(G181210385) - Kemal Güvenç(B181210076)

public class Dispatcher implements IDispatcher {
	private IProcessor processor;
	private IProcessReader processReader;
	private IProcessQueue realTimeQueue;
	private IProcessQueue highestQueue;
	private IProcessQueue mediumQueue;
	private IProcessQueue lowestQueue;
	private int currentTime;

	public Dispatcher(IProcessor processor, IProcessReader processReader) {
		this.processor = processor;
		this.processReader = processReader;
		this.currentTime = 0;
		this.realTimeQueue = new ProcessQueue();
		this.highestQueue = new ProcessQueue();
		this.mediumQueue = new ProcessQueue();
		this.lowestQueue = new ProcessQueue();
	}

	// Önceliği en yüksek olan prosesi döndürür.
	private ISpecialProcess getAppropriateProcess() {
		if (!realTimeQueue.isEmpty())
			return realTimeQueue.getFirstItem();
		else if (!highestQueue.isEmpty())
			return highestQueue.dequeue();
		else if (!mediumQueue.isEmpty())
			return mediumQueue.dequeue();
		else if (!lowestQueue.isEmpty())
			return lowestQueue.dequeue();
		else
			return null;
	}

	// Verilen prosesi kendisine uygun olan kuyruğa yerleştirir.
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

	// Bütün kuyrukları gezip 20 saniye bekleme süresini aşan prosesleri
	// sonlandırır.
	private void terminateTimeOut() {
		IProcessQueue deletedProcesses;

		deletedProcesses = this.highestQueue.increaseWaitingTime();
		while (!deletedProcesses.isEmpty()) {
			var process = deletedProcesses.dequeue();
			process.setStatement(Statement.TimeOut);
			processor.run(process, currentTime);
			this.highestQueue.delete(process);
		}

		deletedProcesses = this.mediumQueue.increaseWaitingTime();
		while (!deletedProcesses.isEmpty()) {
			var process = deletedProcesses.dequeue();
			process.setStatement(Statement.TimeOut);
			processor.run(process, currentTime);
			this.mediumQueue.delete(process);
		}

		deletedProcesses = this.lowestQueue.increaseWaitingTime();
		while (!deletedProcesses.isEmpty()) {
			var process = deletedProcesses.dequeue();
			process.setStatement(Statement.TimeOut);
			processor.run(process, currentTime);
			this.lowestQueue.delete(process);
		}
	}

	@Override
	public void start() {
		while (true) {
			IProcessQueue receivedProcesses = processReader.getProcesses(currentTime);
			ISpecialProcess process;

			// Yeni proses gelmiş mi diye kontrol ediyor.
			while (!receivedProcesses.isEmpty()) {
				process = receivedProcesses.dequeue();
				process.setStatement(Statement.Ready);
				queueProcess(process);
			}

			// Kuyruklarda uygun olan prosesi alır.
			process = getAppropriateProcess();

			// Kuyruklarda proses olmadığım zamanlar için
			if (process == null)
				// Hem kuyruklarda hem de gelecek başka proses olmadığı zaman için
				if (processReader.isEmpty()) {
					this.processor.run(null, currentTime);
					break;
				} else {
					++this.currentTime;
					terminateTimeOut();
					continue;
				}

			process.setStatement(Statement.Running);
			processor.run(process, currentTime);
			++this.currentTime;
			terminateTimeOut();
			process.resetWaitingTime();
			process.decreasePriority();

			if (process.getBurstTime() == 0) {
				if (process.getPriority() == Priority.RealTime)
					realTimeQueue.dequeue();
				process.setStatement(Statement.Terminated);
			} else {
				process.setStatement(Statement.Ready);
				if (process.getPriority() != Priority.RealTime)
					queueProcess(process);
			}
		}
		System.out.println("\nBütün prosesler listelendi.");
	}

}
