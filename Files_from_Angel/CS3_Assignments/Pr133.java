import java.io.*;
import java.util.*;
public class Pr133 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr133.dat"));
		int end = scan.nextInt();
		for (int e = 0; e < end; e++) {
			int sets = scan.nextInt();
			scan.nextLine();
			int[][] graph = new int[sets * 2][sets * 2];
			TreeMap<String, Integer> m = new TreeMap<String, Integer>();
			int count = 0;
			for (int s = 0; s < sets; s++) {
				String[] line = scan.nextLine().split(" ");
				if (!m.containsKey(line[0])) {
					m.put(line[0], count++);
				}
				if (!m.containsKey(line[1])) {
					m.put(line[1], count++);
				}
				graph[m.get(line[0])][m.get(line[1])] = Integer.parseInt(line[2]);
				graph[m.get(line[1])][m.get(line[0])] = Integer.parseInt(line[2]);
			}
			int total = 0;
			int extra = Integer.MAX_VALUE;
			for (int j = 0; j < graph[0].length; j++) {
				int temp = Integer.MAX_VALUE;
				for (int i = 0; i < graph.length; i++) {
					if (graph[i][j] > 0 && graph[i][j] < temp) {
						temp = graph[i][j];
					}
					if (temp < extra) {
						extra = temp;
					}
				}
				if (temp != Integer.MAX_VALUE) {
					total += temp;
				}
			}
			total -= extra;
			System.out.println(total);
		}
	}
}
