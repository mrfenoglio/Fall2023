import java.io.*;
import java.util.*; 
public class science {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("science.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			double d = scan.nextDouble();
			int a = scan.nextInt();
			int b = scan.nextInt();
			System.out.println((int) Math.round(d*Math.pow(a, b))); 
		}
}

}