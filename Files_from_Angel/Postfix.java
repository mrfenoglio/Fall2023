import java.io.*;
import java.util.*;
public class Postfix {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("postfix.dat"));
		int end = scan.nextInt();
		scan.nextLine();
		for (int e = 0; e < end; e++) {
			String[] line = scan.nextLine().split(" ");
			ArrayList<String> problem = new ArrayList<String>();
			for (String s: line) {
				problem.add(s);
			}
			for (int i = 0; i < problem.size() - 1; i++) {
				if (problem.get(i).equals("/") || problem.get(i).equals("*")) {
					String temp = problem.get(i);
					problem.set(i, problem.get(i + 1));
					problem.set(i + 1, temp);
					i++;
				}
			}
			for (int i = 0; i < problem.size() - 1; i++) {
				if (problem.get(i).equals("+") || problem.get(i).equals("-")) {
					if (i < problem.indexOf("/") || i < problem.indexOf("*")) {
						int index = 0;
						String temp = problem.get(i);
						if (problem.indexOf("/") > problem.indexOf("*")) {
							index = problem.indexOf("/");
						}
						if (problem.indexOf("/") < problem.indexOf("*")) {
							index = problem.indexOf("*");
						}
						problem.remove(i);
						problem.add(index, temp);
					}
					else {
						String temp = problem.get(i);
						problem.set(i, problem.get(i + 1));
						problem.set(i + 1, temp);
						i++;
					}
				}
			}
			for (String s: problem) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
