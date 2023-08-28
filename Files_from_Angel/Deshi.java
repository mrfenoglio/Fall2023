import java.util.*;
import java.io.*;
public class Deshi {
	public static void deshi() throws IOException{
		Scanner scan = new Scanner(new File("deshi.dat"));
		String s;
		while (scan.hasNextLine()) {
			s = scan.nextLine();
			boolean good = true;
			int vowel = 0;
			int consonants = 0;
			for (int i = 0; i < s.length(); i++) {
				String c = s.substring(i, i + 1);
				if (!c.equals("a") && !c.equals("e") && !c.equals("i") && !c.equals("o") && !c.equals("u")) {
					consonants++;
					}
				 if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
					consonants = 0;					
					}
				if (consonants > 7) {
					good = false;
					break;
					}
			}
			for (int i = 0; i < s.length(); i++) {
				String v = s.substring(i, i + 1);
				if (v.equals("a") || v.equals("e") || v.equals("i") || v.equals("o") || v.equals("u")) {
					vowel++;					
					}
				 if (!v.equals("a") && !v.equals("e") && !v.equals("i") && !v.equals("o") && !v.equals("u")) {
					vowel = 0;
					}
				if (vowel > 4) {
					good = false;
					break;
					}
			}
			if (good) {
				System.out.println("ACCEPTABLE " + s);
			}
			else {
				System.out.println("NOT ACCEPTABLE " + s);
			}
		}
	}
}
