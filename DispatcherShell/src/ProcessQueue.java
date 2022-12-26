public class ProcessQueue implements IProcessQueue {
	private Node<ISpecialProcess> front;
	private Node<ISpecialProcess> back;
	private Priority priority;

	public ProcessQueue(Priority priority) {
		
		front = back = null;
		
	}

	@Override
	public void enqueue(ISpecialProcess data) {
		// TODO Auto-generated method stub
		
		Node<ISpecialProcess> tmp = new Node<ISpecialProcess>(data);
		if(isEmpty()){
			front = back = tmp;
			
		}
		else{
			back.next = tmp;
			back = back.next;
			
		}

	}

	@Override
	public ISpecialProcess dequeue() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			front = front.next;
		}
		else if(front==null){
			back = null;
		}
		return front.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return front == null;
	}

	@Override
	public ISpecialProcess[] search(int destinationTime) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void delete(ISpecialProcess process) {
		// TODO Auto-generated method stub

	}
}
