import java.io.*;
import java.util.*;

public class Polina {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("polina.dat"));
		
		while (scan.hasNext())
		{
			String[] input = scan.nextLine().split(" ");
			String message = input[0];
			List<String> mChars = new ArrayList<>();
			for (int i = 0; i < message.length(); i++)
			{
				mChars.add(message.substring(i, i+1));
			}

			for (int i = 1; i < input.length; i++)
			{
				String hex= Integer.toHexString(Integer.parseInt(input[i]));
				int hex1 = Integer.parseInt(hex.substring(0, 1), 16);
				//int hex2 = Integer.parseInt(hex.substring(1, 2), 16);
				int hex3 = Integer.parseInt(hex.substring(2, 3), 16);
				
				int dig1 = Integer.parseInt(input[i].substring(0, 1));
				int dig2 = Integer.parseInt(input[i].substring(1, 2));
				int dig3 = Integer.parseInt(input[i].substring(2, 3));
	
				
				if (dig1 % 2 == 0)
				{
					Collections.swap(mChars, dig2-1, dig3-1); 
				}
				else
				{
					Collections.swap(mChars, mChars.size()-dig2, mChars.size()-dig3); 
				}
				
				
				if (i == 1)
				{
					mChars.add(0, "A");
					mChars.add("A");
					mChars.add("A");
				}
				mChars.add(0, String.valueOf(hex1));
				mChars.add(String.valueOf(hex3));
			}

			System.out.print(message + " ");
			for (String ch: mChars)
			{
				System.out.print(ch);
			}
			System.out.println();
			
			
		}
	}
}
