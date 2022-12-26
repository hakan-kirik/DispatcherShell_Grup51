public interface IProcessQueue extends IQueue<ISpecialProcess> {
	ISpecialProcess[] search(int destinationTime);

	void delete(ISpecialProcess process);
}