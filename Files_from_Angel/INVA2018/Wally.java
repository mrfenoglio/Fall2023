import java.io.*;
import java.util.*;
public class Wally {
	public static void wally() throws IOException{
		Scanner scan = new Scanner(new File("wally.dat"));
		ArrayList<String> vali = new ArrayList<String>();
		ArrayList<String> keywords = new ArrayList<String>();
		boolean end = false;
		while (scan.hasNextLine()) {
			String word = scan.nextLine();
			if (word.equals("999")) {
				end = true;
				word = scan.nextLine();
			}
			if (!end) {
				keywords.add(word);
			}
			if (end) {
				boolean valid = true;
				for (int i = 0; i < keywords.size(); i++) {
					if (word.equals(keywords.get(i))) {
						valid = false;
					}
				}
				if (!word.matches("[a-zA-Z_$][\\w$]*")) {
					valid = false;
				}
				if (valid) {
					vali.add(word);
				}
			}
		}
		for (int i = 0; i < vali.size() - 1; i++) {
			for (int j = i + 1; j < vali.size(); j++) {
				if (vali.get(i).compareTo(vali.get(j)) > 0) {
					String temp = vali.get(i);
					vali.set(i, vali.get(j));
					vali.set(j, temp);
				}
			}
		}
		for (int i = 0; i < vali.size(); i++) {
			System.out.println(vali.get(i));
		}
	}
}
