public class Node<A> {
	public Node<A> next;
	public Node<A> prev;
	public A data;

	public Node(A data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}
