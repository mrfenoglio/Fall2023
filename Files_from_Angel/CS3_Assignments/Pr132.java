import java.io.*;
import java.util.*;

public class Pr132 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr132.dat"));
		int start = scan.nextInt();
		boolean[][] graph = new boolean[start * 2][start * 2];
		int[][] distance = new int[start * 2][start * 2];
		TreeMap<String, Integer> m = new TreeMap<String, Integer>();
		int count = 0;
		scan.nextLine();
		while (start-->0) {
			String[] line = scan.nextLine().split(" ");
			if (!m.containsKey(line[0])) {
				m.put(line[0], count++);
			}
			if (!m.containsKey(line[1])) {
				m.put(line[1], count++);
			}
			graph[m.get(line[0])][m.get(line[1])] = true;
			graph[m.get(line[1])][m.get(line[0])] = true;
			distance[m.get(line[0])][m.get(line[1])] = Integer.parseInt(line[2]);
			distance[m.get(line[1])][m.get(line[0])] = Integer.parseInt(line[2]);
			count++;
		}
		int numpath = scan.nextInt();
		scan.nextLine();
		for (int n = 0; n < numpath; n++) {
			String[] line = scan.nextLine().split(" ");
			int dist[] = new int[count];
			boolean sptSet[] = new boolean[count];
			for (int j = 0; j < count; j++) {
				dist[j] = Integer.MAX_VALUE;
				sptSet[j] = false;
			}
			dist[m.get(line[0])] = 0;
			int minI = 0;
			while (minI!=-1) {
				for (int j = 0; j < count - 1; j++) {
					int min = Integer.MAX_VALUE;
					minI = -1;
					for (int k = 0; k < count; k++) {
						if (sptSet[k] == false && dist[k] <= min) {
							min = dist[k];
							minI = k;
						}
					}
				}
				if (minI==-1)
					break;
				sptSet[minI] = true;
				for (int v = 0; v < count; v++) {
					if (!sptSet[v] && distance[minI][v] != 0 && dist[minI] != Integer.MAX_VALUE
						&& dist[minI] + distance[minI][v] <= dist[v]) {
						dist[v] = dist[minI] + distance[minI][v];
					}
				}
			}
			System.out.println(dist[m.get(line[1])]);
		}
	}
}
