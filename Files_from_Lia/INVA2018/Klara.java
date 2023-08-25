import java.io.*;
import java.util.*;

public class Klara {
	static void solve(int size, char[][] grid)
	{
		int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		char mid = grid[size/2][size/2];
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {size/2, size/2});
		
		while (!q.isEmpty())
		{
			int[] check = q.poll();
			for (int i = 0; i < moves.length; i++)
			{
				int r = check[0] + moves[i][0];
				int c = check[1] + moves[i][1];
				if (r >= 0 && r < size && c >= 0 && c < size && grid[r][c] == mid)
				{
					grid[r][c] = '-';
					q.add(new int[] {r, c});
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("klara.dat"));
		while (scan.hasNext())
		{
			int size = Integer.parseInt(scan.nextLine());
			char[][] grid = new char[size][size];
			for (int i = 0; i < size; i++)
			{
				grid[i] = scan.nextLine().toCharArray();
			}
			solve(size, grid);
			for (char[] row: grid)
			{
				for (char c: row)
				{
					System.out.print(c);
				}
				System.out.println();
			}
			System.out.println("=====");
		}
	}
}
