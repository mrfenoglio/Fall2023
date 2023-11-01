import java.util.*;
import java.io.*;
public class Chaoxiang {
	public static void chaoxiang() throws IOException {
		Scanner scan = new Scanner(new File("chaoxiang.dat"));
		double f = 0;
		while (scan.hasNextLine()) {
			f = scan.nextDouble();
			double k = (f - 32)/1.8 + 273.16;
			System.out.printf("%.2f\n", k);
		}
	}
}
