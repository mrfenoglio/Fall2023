import java.util.*;
import java.io.*;
public class Klara {
	public static void klara() throws IOException{
		Scanner scan = new Scanner(new File("klara.dat"));
		while (scan.hasNextLine()) {
			int num = scan.nextInt();
			String[] [] arr = new String[num][num];
			for (int i = 0; i < num; i++) {
				String word = scan.next();
				for (int j = 0; j < num; j++) {
					arr[i][j] = word.substring(j, j + 1);
				}
			}
			int mid = num/2;
			String abmid = arr[mid][mid];
			String replace = "-";
			arr[mid][mid] = replace;
			for (int a = 0; a < num; a++) {
				for (int i = 0; i < num; i++) {
					for (int j = 0; j < num; j++) {
						if (arr[i][j].equals(abmid) && ((i != 0 && arr[i - 1][j].equals(replace)) || (i != num - 1 && arr[i + 1][j].equals(replace)) || (j != 0 && arr[i][j - 1].equals(replace)) || (j != num - 1 && arr[i][j + 1].equals(replace)))) {
							arr[i][j] = replace;
						}
					}
				}
			}
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.out.print("=====\n");
		}
	}
}
