import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Linus {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("linus.dat"));
		int numSets = Integer.parseInt(scan.nextLine());
		
		while (numSets-- > 0)
		{
			String[] in = scan.nextLine().split(" ");
			BigInteger n = new BigInteger(in[0]); // numerator
			BigInteger d = new BigInteger(in[1]); // denominator
			
			// simplify the fraction
			BigInteger gcd = n.gcd(d); // the greatest common factor to divide the numerator and denominator by
			n = n.divide(gcd);
			d = d.divide(gcd);
			
			BigInteger[] divide = n.divideAndRemainder(d);
			BigInteger quo = divide[0]; // quotient
			BigInteger remainder = divide[1];
			
			if (remainder.intValue() != 0) // if there is a remainder, it is either a plain fraction or a mixed number
			{
				if (quo.intValue() != 0) // if there is a nonzero quotient and a remainder, it is a mixed number
					System.out.println(quo + " " + remainder + "/" + d);
				else // if there is zero quotient and a remainder, it is just a fraction
					System.out.println(n + "/" + d);
			}
			else // if there is no remainder, it is a whole number
			{
				System.out.println(quo);
			}
		}
	}
}
