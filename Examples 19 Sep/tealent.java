import java.io.*;
import java.util.*;

public class tealent {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("talent.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int tar = scan.nextInt();
			scan.nextLine();
			String[] arr = scan.nextLine().split("\\s+");
			int [] nums= new int[arr.length];
			for(int i = 0; i<arr.length;i++) {
				nums[i]= Integer.parseInt(arr[i]);
				
			}
			Set<Integer> set= new HashSet<>();
			int min =Integer.MAX_VALUE; 
			loop:
			for(int j = 0; j<arr.length-tar; j++) {
				int counter = 0;
			for(int i = j; i<arr.length; i++) {
				set.add(nums[i]);
				counter++;
				if(set.size()==tar) {
					if(counter<min)
						min = counter;
					set.clear();
					continue loop;
				}
					
			}
		}
			if(min ==Integer.MAX_VALUE  )
				System.out.println(-1);
			else
				System.out.println(min);

				
			
			
		}
	}

}
