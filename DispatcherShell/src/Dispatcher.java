public class Dispatcher implements IDispatcher {
	private IProcessor processor;
	private IProcessReader processReader;
	private IQueue realTimeQueue;
	private IQueue highestQueue;
	private IQueue mediumQueue;
	private IQueue lowestQueue;
	private int currentTime;
	
	public Dispatcher(IProcessor processor, IProcessReader processReader) {
		
	}
	
	private ISpecialProcess getAppropriateProcess() {
		return null;
	}
	
	private void queueProcess(ISpecialProcess process) {
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

}