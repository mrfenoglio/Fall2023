import java.io.*;
import java.util.*;

public class Deshi {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("deshi.dat"));
		while (scan.hasNext())
		{
			String input = scan.nextLine();
			System.out.println(!(input.matches(".*[aeiou]{4}.*") || input.matches(".*![aeiou]{7}.*")) ? "ACCEPTABLE " + input : "NOT ACCEPTABLE " + input);
		}
	}
}
