import java.io.*;
import java.util.*;
public class Digits {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("digits.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int n = scan.nextInt();
			while(n>9) {
				n = add(n);
				
			}
			System.out.println(n);
			
		}
}

static int add(int n) {
	if(n<=0)
		return 0;
	return n%10 +add(n/10);

}

}
