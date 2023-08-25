import java.io.*;
import java.util.*;

public class Wally {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("wally.dat"));
		
		List<String> reserved = new ArrayList<>();
		
		// just because the directions specifically mentioned these, to be safe
		reserved.add("true");
		reserved.add("false");
		reserved.add("null");
		
		while (scan.hasNext())
		{
			String word = scan.nextLine();
			if (word.equals("999"))
				break;
			reserved.add(word);
		}
		
		List<String> ids = new ArrayList<>();
		Comparator<String> alpha = (a, b) -> a.compareTo(b);
		while (scan.hasNext())
		{
			String id = scan.nextLine();
			
			if (id.matches("[a-zA-Z_$][\\w$]*"))
				if (!reserved.contains(id))
					ids.add(id);
		}
		
		ids.sort(alpha);
		for (String id: ids)
			System.out.println(id);
	}
}
