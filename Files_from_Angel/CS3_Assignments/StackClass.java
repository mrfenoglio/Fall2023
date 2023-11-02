import java.util.*;
public class StackClass {
	private List<Object> stack;
	public StackClass() {
		stack = new ArrayList();
	}
	public int size() {
		return stack.size();
	}
	public void push(Object s) {
		stack.add(s);
	}
	public Object peek() {
		return stack.get(this.size());
	}
	public Object pop() {
		return stack.get(this.size());
	}
	public boolean isEmpty() {
		return stack.size() == 0;
	}
}
