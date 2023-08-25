import java.io.*;
import java.util.*;

public class Stelios {
	static void print(int[][] mat)
	{
		for (int[] row: mat)
		{
			for (int i : row)
				System.out.print(i + " ");
			System.out.println();
		}
		
		for (int i = 0; i < mat.length*2-1; i++)
			System.out.print("-");
		System.out.println("\n");
	}
	
	static int steps(int[][] mat, int start, int end)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start, 0});

		while (!q.isEmpty())
		{
			int[] curr = q.poll();
			
			if (curr[0] == end)
			{
				return curr[1];
				
			}

			if (mat[curr[0]][end] == 1)
			{
				return curr[1]+1;
			}
				
			for (int i = 0; i < mat.length; i++)
			{
				if (mat[curr[0]][i] > 0)
					q.add(new int[] {i, curr[1] + mat[curr[0]][i]});
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("stelios.dat"));
		
		while (scan.hasNext())
		{
			String[] input = scan.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			
			int[][] mat = new int[n][n];
			for (int i = 1; i < input.length; i++)
			{
				char first = input[i].charAt(0);
				char second = input[i].charAt(1);
				
				mat[first-65][second-65] = 1;
				mat[second-65][first-65] = 1;
			}
			
			for (int r = 0; r < n; r++)
			{
				for (int c = 0; c < n; c++)
				{
					if (mat[r][c] == 0 && r != c)
					{
						mat[r][c] = steps(mat, r, c);
						mat[c][r] = mat[r][c];
					}
				}
			}
			print(mat);
		}
	}
}
