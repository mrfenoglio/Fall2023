import java.util.*;
public class MapClass {
	private List<String> index;
	private List<Integer> value;
	public MapClass() {
		index = new ArrayList();
		value = new ArrayList();
	}
	public void put(String s, int i) {
		index.add(s);
		value.add(i);
	}
	public int get(String s) {
		return value.get(index.indexOf(s));
	}
	public boolean isEmpty() {
		return index.size() == 0;
	}
	public int size() {
		return index.size();
	}
	public int remove(String s) {
		int temp = value.get(index.indexOf(s));
		value.remove(index.indexOf(s));
		index.remove(s);
		return temp;
	}
}
