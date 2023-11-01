import java.io.*;
import java.util.*;
public class Rocio {
	public static void rocio() throws IOException {
		Scanner scan = new Scanner(new File("rocio.dat"));
		while (scan.hasNextLine()) {
			int area = scan.nextInt();
			int outside = scan.nextInt();
			String[][] pattern = new String[area][area];
			for (int i = 0; i < outside; i++) {
				pattern[i][i] = "*";
				pattern[i][area - 1 - i] = "*";
				pattern[area - 1 - i][i] = "*";
				pattern[area - 1 - i][area - 1 - i] = "*";
			}
			for (int i = outside; i < area - outside; i++) {
				for (int j = outside; j < area - outside; j++) {
					pattern[i][j] = "*";
				}
			}
			for (int i = 0; i < area; i++) {
				for (int j = 0; j < area; j++) {
					if (pattern[i][j] == null) {
						pattern[i][j] = " ";
					}
				}
			}
			for (int i = 0; i < area; i++) {
				for (int j = 0; j < area; j++) {
					System.out.print(pattern[i][j]);
				}
				System.out.println();
			}
			for (int i = 0; i < area; i++) {
				System.out.print("=");
			}
			System.out.println("\n");
		}
	}
}
