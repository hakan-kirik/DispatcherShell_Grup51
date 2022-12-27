public interface IProcessQueue extends IQueue<ISpecialProcess> {
	ISpecialProcess[] increaseWaitingTime(int waitingTime);

	void delete(ISpecialProcess process);
}