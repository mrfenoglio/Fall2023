import java.util.*;
import java.io.*;

public class Chaoxiang {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("chaoxiang.dat"));
		while (scan.hasNext())
		{
			double f = Double.parseDouble(scan.nextLine());
			System.out.printf("%.2f\n", (f-32)/1.8 + 273.16);
		}
	}
}
