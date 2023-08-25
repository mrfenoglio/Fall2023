import java.io.*;
import java.util.*;

public class Rocio {
	static void print(char[][] star)
	{
		for (char[] r: star)
		{
			for (char c : r)
			{
				System.out.print(c);
			}
			System.out.println();
		}
		for (int i = 0; i < star.length; i++)
		{
			System.out.print("=");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rocio.dat"));
		
		while (scan.hasNext())
		{
			String[] input = scan.nextLine().split(" ");
			int squareSize = Integer.parseInt(input[0]);
			int spineSize = Integer.parseInt(input[1]);
			
			char[][] star = new char[squareSize][squareSize];
			for (int rc = 0; rc < squareSize; rc++)
				star[rc][rc] = '*';
			
			for (int r = 0, c = squareSize-1; r < squareSize && c >= 0; r++, c--)
				star[r][c] = '*';
			
			for (int r = spineSize; r < squareSize - spineSize; r++)
			{
				for (int c = spineSize; c < squareSize - spineSize; c++)
					star[r][c] = '*';
			}
			
			print(star);
		}
	}
}
