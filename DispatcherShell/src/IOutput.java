public interface IOutput {
	void processStart(ISpecialProcess process);
	void processContinue(ISpecialProcess process);
	void processInterrupted(ISpecialProcess process);
	void processTerminated(ISpecialProcess process);
	void processTimeOut(ISpecialProcess process);
}