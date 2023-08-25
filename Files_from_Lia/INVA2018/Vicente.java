import java.io.*;
import java.util.*;

public class Vicente {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("vicente.dat"));
		
		while (scan.hasNext())
		{
			String[] input = scan.nextLine().split(" ");
			String bit = input[0];
			String desiredParity = input[1];
			
			System.out.print(Integer.toHexString(Integer.parseUnsignedInt(bit, 2)).toUpperCase() + " "); // original string
			
			int parity = 0;
			for (int i = 0; i < bit.length(); i++)
				parity += Integer.parseInt(bit.substring(i, i+1));
			
			if (desiredParity.equals("EVEN"))
			{
				if (parity % 2 == 0)
					bit += "0";
				else
					bit += "1";
			}
			else // desiredParity is ODD
			{
				if (parity % 2 != 0)
					bit += "0";
				else
					bit += "1";
			}
			
			System.out.println(Integer.toHexString(Integer.parseUnsignedInt(bit, 2)).toUpperCase()); // adjusted string
			
		}
	}
}
