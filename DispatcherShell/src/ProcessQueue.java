public class ProcessQueue implements IProcessQueue {
	private Node<ISpecialProcess> front;
	private Node<ISpecialProcess> back;
	private Priority priority;

	public ProcessQueue(Priority priority) {

	}

	@Override
	public void enqueue(ISpecialProcess data) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISpecialProcess dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node<ISpecialProcess>[] search(int destinationTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Node<ISpecialProcess> process) {
		// TODO Auto-generated method stub

	}
}