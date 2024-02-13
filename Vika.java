import java.io.*;
import java.util.*;
public class Vika {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("vika.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			char[] s1 = scan.next().toCharArray();
			char[] s2 = scan.next().toCharArray();
			int[][] arr = new int[s1.length+1][s2.length+1];
			int max = 0;
			for(int i = 1; i<arr.length; i++) {
				
				for(int j = 1; j<arr[0].length; j++) {
					//int toAdd = Math.max()
					if(s2[j-1]==s1[i-1])
						arr[i][j]=Math.max(1+arr[i-1][j-1], Math.max(arr[i-1][j], arr[i][j-1]));
					
					else arr[i][j]=Math.max(arr[i-1][j-1], Math.max(arr[i-1][j], arr[i][j-1]));
				
					if(max<arr[i][j])
						max = arr[i][j];
				}
				
			}
			System.out.println(max);
					
			
		}
		
	
}

}
