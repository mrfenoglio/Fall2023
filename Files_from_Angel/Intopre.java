import java.io.*;
import java.util.*;
public class Intopre {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("intopre.dat"));
		int end = scan.nextInt();
		scan.nextLine();
		for (int e = 0; e < end; e++) {
			String[] line = scan.nextLine().split(" ");
			ArrayList<String> problem = new ArrayList<String>();
			for (String i: line) {
				problem.add(i);
			}
			while (problem.size() > 1) {
				int answer = 0;
				int index = 0;
				for (int i = 1; i < problem.size() - 1; i++) {
					if ((problem.contains("*") || problem.contains("/"))) {
						if (problem.get(i).equals("*")) {
							int one = Integer.parseInt(problem.get(i - 1));
							int two = Integer.parseInt(problem.get(i + 1));
							answer = one * two;
							index = i;
							break;
						}
						else if (problem.get(i).equals("/")) {
							int one = Integer.parseInt(problem.get(i - 1));
							int two = Integer.parseInt(problem.get(i + 1));
							answer = one / two;
							index = i;
							break;
						}
					}
					else {
						if (problem.get(i).equals("+")) {
							int one = Integer.parseInt(problem.get(i - 1));
							int two = Integer.parseInt(problem.get(i + 1));
							answer = one + two;
							index = i;
							break;
						}
						else if (problem.get(i).equals("-")) {
							int one = Integer.parseInt(problem.get(i - 1));
							int two = Integer.parseInt(problem.get(i + 1));
							answer = one - two;
							index = i;
							break;
						}
					}
				}
				problem.set(index, String.valueOf(answer));
				problem.remove(index + 1);
				problem.remove(index - 1);
			}
			System.out.println(problem.get(0));
		}
	}
}
