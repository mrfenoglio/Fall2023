import java.io.*;
import java.util.*;
public class Pr131 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr131.dat"));
		while (scan.hasNext()) {
			int num = scan.nextInt();
			scan.nextLine();
			TreeMap<String, Integer> m = new TreeMap<String, Integer>();
			boolean[][] graph = new boolean[num * 2][num * 2];
			int count = 0;
			for (int n = 0; n < num; n++) {
				String[] line = scan.nextLine().split(" ");
				if (!m.containsKey(line[0])) {
					m.put(line[0], count++);
				}
				if (!m.containsKey(line[1])) {
					m.put(line[1], count++);
				}
				graph[m.get(line[0])][m.get(line[1])] = true;
			}
			int numpath = scan.nextInt();
			A: while (numpath-->0) {
				int a = m.get(scan.next());
				int b = m.get(scan.next());
				Queue<Integer> q = new LinkedList<>();
				q.add(a);
				q.add(0);
				int counter = 0;
				while (!q.isEmpty()) {
					int n = q.poll();
					int d = q.poll();
					if (n==b) {
						System.out.println(d);
						continue A;
					}
					for (int c = 0; c < graph.length; c++) {
						if(graph[n][c]) {
							q.add(c);
							q.add(d+1);
						}
					}
					counter++;
					if (counter > graph.length * graph.length) {
						break;
					}
				}
				System.out.println("NO PATH");
			}
		}
	}
}
