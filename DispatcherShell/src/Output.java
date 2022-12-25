public class Output implements IOutput {
	private IOutput instance;
	
	private Output() {
		
	}

	public static IOutput getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processStart(ISpecialProcess process, int destinationTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processContinue(ISpecialProcess process, int destinationTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processInterrupted(ISpecialProcess process, int destinationTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processTerminated(ISpecialProcess process, int destinationTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processTimeOut(ISpecialProcess process, int destinationTime) {
		// TODO Auto-generated method stub

	}

}