public interface IQueue {
	void enqueue(ISpecialProcess process);
	ISpecialProcess dequeue();
	boolean isEmpty();
}