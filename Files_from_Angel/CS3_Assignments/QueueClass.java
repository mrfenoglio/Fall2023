import java.util.*;
public class QueueClass {
	private List<Integer> queue;
	public QueueClass() {
		queue = new ArrayList();
	}
	
	public int size() {
		return queue.size();
	}
	
	public Object poll() {
		Object first = queue.get(0);
		queue.remove(0);
		return first;
	}
	
	public Object peek() {
		return queue.get(0);
	}
	
	public boolean offer(Integer o) {
		if (queue.add(o)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isEmpty() {
		return queue.size() == 0;
	}
}
