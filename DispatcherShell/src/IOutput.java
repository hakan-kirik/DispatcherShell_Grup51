public interface IOutput {
	void processStart(ISpecialProcess process, int destinationTime);
	void processContinue(ISpecialProcess process, int destinationTime);
	void processInterrupted(ISpecialProcess process, int destinationTime);
	void processTerminated(ISpecialProcess process, int destinationTime);
	void processTimeOut(ISpecialProcess process, int destinationTime);
}