import java.util.LinkedList;
import java.util.List;

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
		if (isEmpty()) {
			front = back = tmp;

		} else {
			back.next = tmp;
			back = back.next;

		}

	}

	@Override
	public ISpecialProcess dequeue() {
		// TODO Auto-generated method stub
		if (!isEmpty()) {
			front = front.next;
		} else if (front == null) {
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
	public ISpecialProcess[] increaseWaitingTime(int waitingTime) {
		// TODO Auto-generated method stub
		Node<ISpecialProcess> tmp = front;
		List<ISpecialProcess> list = new LinkedList<ISpecialProcess>();

		while(tmp !=null){
			if(tmp.data.increaseWaitingTime()){
				list.add(tmp.data);
			}
			tmp = tmp.next;
		}

		ISpecialProcess[] arr = (ISpecialProcess[]) list.toArray();
		
		return arr;
	}

	@Override
	public void delete(ISpecialProcess process) {
		// TODO Auto-generated method stub
		Node<ISpecialProcess> del;
		del = front;
		while (del.data != process) {
			del = del.next;
			if (del == null)
				return;
		}
		if (del == front)
			front = front.next;

		else
			del.prev.next = del.next;

		if (del == back)
			back = del.prev;
		else
			del.prev.next = del.prev;
	}
}
