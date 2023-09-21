import java.io.*;
import java.util.*;
public class Mirror {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("mirror.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
			String[] arr = scan.nextLine().split("\\s+");
			for(String s: arr)
				System.out.print(new StringBuilder(s).reverse()+" ");
			System.out.println();
			
		}
}

}
