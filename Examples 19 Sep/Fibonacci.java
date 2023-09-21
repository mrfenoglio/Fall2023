import java.io.*;
import java.util.*;

public class Fibonacci {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("fibonacci.dat"));
		int noSets = scan.nextInt();
		int[] fig = new int[50];
		fig[0]=1;
		fig[1]= 1;
		for(int i = 2; i<49; i++) {
			fig[i]= fig[i-1]+fig[i-2];
		}
		while(noSets-->0) {
			int target = scan.nextInt();
			int[] nums = new int[target];
			for(int i = 0; i<target; i++)
				nums[i]= scan.nextInt();
			//System.out.println(Arrays.toString(nums));
			int sum = 0;
			for(int s: nums) {
				sum+=fig[s-1];
			}
			System.out.println(sum);
			
		}
	}

}
