import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;
public class Determined2 {
	static int answer;
	static int[][] minor(int col, int[][] arr){
		int[][] ans = new int[arr.length-1][arr.length-1];
		for(int j = 0; j<col; j++) {
			for(int i = 1; i<arr.length; i++) {
				ans[i-1][j]= arr[i][j];
			}
			
		}
		for(int j = col+1; j<arr.length; j++) {
			for(int i = 1; i<arr.length; i++) {
				ans[i-1][j-1]= arr[i][j];
			}
			
		}
//		for(int[] row: ans) {
//			System.out.println(Arrays.toString(row));
//		}
		return ans;
	}
	
	static int solve(int[][] arr) {
		if(arr.length==2) {
			return arr[0][0]*arr[1][1]-arr[1][0]*arr[0][1];
			//atom.set(n);
			}
		int n = 0;
		
			for(int i = 0; i<arr.length; i++) {
				n+=(int)Math.pow(-1,i)*arr[0][i]*solve(minor(i,arr)); 
			}
		
		return n;
	}
	
public static void main(String... args) throws IOException {
	Scanner scan = new Scanner(new File("determined.dat"));
	int noSets = scan.nextInt();
	while (noSets-- > 0) {
		answer = 0;
		scan.nextLine();
		String[] inp = scan.nextLine().split("\\s+");
		int len = inp.length;
		int[][] matrix = new int[len][len];
		for(int i =0; i<len; i++) {
			matrix[0][i]= Integer.parseInt(inp[i]);
			
		}
		for(int i =1; i<len; i++) {
			for(int j=0; j<len; j++ )
				matrix[i][j]= scan.nextInt();
		}
		
		AtomicInteger atom = new AtomicInteger();
		
				 int ans = solve(matrix);
				 System.out.println(ans);
		

	}

}
}
