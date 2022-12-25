public interface IProcessQueue extends IQueue<ISpecialProcess> {
	Node<ISpecialProcess>[] search(int destinationTime);
	void delete(Node<ISpecialProcess> process);
}