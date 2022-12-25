public interface IProcessQueue extends IQueue<ISpecialProcess> {
	Node<SpecialProcess>[] search(int destinationTime);
	void delete(Node<SpecialProcess> process);
}