public interface IQueue<A> {
	void enqueue(A data);
	A dequeue();
	boolean isEmpty();
}