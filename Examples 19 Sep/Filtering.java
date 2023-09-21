import java.io.*;
import java.util.*;
public class Filtering {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("filter.dat"));
		int noSets = scan.nextInt();
		Comparator<String> comp = (a,b)-> a.compareToIgnoreCase(b); 
		while(noSets-->0) {
			int level = scan.nextInt();
			scan.nextLine();
			String[] arr = scan.nextLine().split("\\s+");
			Arrays.sort(arr,comp);
			for(String s: arr) {
				if(s.length()>=level) {
					System.out.print(s+ " "); 
				}
			}
			System.out.println();
			
			
		}
}
}
