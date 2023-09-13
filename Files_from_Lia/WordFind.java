import java.io.*;
import java.util.*;

public class WordFind {
	static boolean solve(char[][] mat, String word, int startX, int startY, int[][] ans)
	{	
		int[][] moves = {{1,0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {-1, -1}}; // contains all the possible directions we can move from a given position
		
		Queue<int[]> q = new LinkedList<>(); // to store all possible paths in the puzzle matrix we find that could contain the whole word
		
		/*
		 * format: {current row, current column, index of current letter/character position in word}
		 * the current row and column for the first iteration are just the starting coordinates we are given
		 * we start at index 1 in word instead of 0 because we already know for sure that we found the first letter (its our starting position)
		 */
		q.add(new int[] {startX, startY, 1}); 
		
		while (!q.isEmpty()) 
		{
			int[] check = q.poll();
			
			/*
			 * if true, it means we have found all the letters in the word 
			 * if false, it means we did not find all the letters in the word YET, or the word cannot be found from our starting index
			 */
			if (check[2] == word.length()) 
			{
				ans[0] = new int[] {startX+1, startY+1}; // {first letter x,  first letter y}
				ans[1] = new int[] {check[0]+1, check[1]+1}; // {last letter x, last letter y}
				return true;
			}
			
			for (int i = 0; i < moves.length; i++) // test each possible direction from current position
			{
				int r = check[0] + moves[i][0]; // the row index to test
				int c = check[1] + moves[i][1]; // the column index to test
				if (r >= 0 && r < mat.length && c >= 0 && c < mat[r].length) // check if it is in bounds
				{
					if (mat[r][c] == word.charAt(check[2])) // if the new position is the next letter in the word, it means we successfully found the next letter
					{
						/*
						 * we increment check[2] because it represents our current position (index) in the word
						 */
						q.add(new int[] {r, c, check[2]+1}); 
					}
				}
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("wordfind.dat"));
		
		/*
		 * cool little simple way of getting the number of test cases from the data file
		 * much quicker to type than using the nextInt() and nextLine() methods
		 * thank you Raf :D
		 */
		int n = Integer.parseInt(scan.nextLine());
		
		while (n-- > 0)
		{
			String[] rc = scan.nextLine().split(" ");
			int rows = Integer.parseInt(rc[0]);
			int cols = Integer.parseInt(rc[1]);
			
			char[][] mat = new char[rows][cols];
			for (int r = 0; r < rows; r++)
			{
				mat[r] = scan.nextLine().toCharArray();
			}
			
			String[] words = scan.nextLine().split(" ");
			for (String word: words)
			{
				/*
				 * format:
				 * ans[0] = {first letter x, first letter y}
				 * ans[1] = {last letter x, last letter y}
				 * to store the positions of the first and last letter in the word to print later
				 */
				int[][] ans = new int[2][2];
				
				outer: for (int r = 0; r < rows; r++)
				{
					for (int c = 0; c < cols; c++)
					{
						if (mat[r][c] == word.charAt(0)) // if the current position in the puzzle matrix is the first letter of the word, it means we can start searching from there
						{
							boolean foundWord = solve(mat, word, r, c, ans); // we send in int[][] ans so that the answer (if applicable) is stored for us automatically
							
							/*
							 * given the constraint that there is only one unique solution for each word, 
							 * we can break out of the loop and head to the print statement as soon as we find it
							 */
							if (foundWord) 
							{
								break outer; // to make sure we break out of the nested loop entirely
							}
						}
					}
				}
				
				System.out.println(ans[0][0] + " " + ans[0][1] + " " + ans[1][0] + " " + ans[1][1]); // print the answer in the required format
			}
		}
	}
}
