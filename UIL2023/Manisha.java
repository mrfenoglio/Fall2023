import java.io.*;
import java.util.*;

public class Manisha {
// rank recursively returns an int which compares two arrays by alpha if their lengths are the same
	static int rank(String[] a, String[] b, int index) {
		if(a.length!=b.length)
			return 0;
		if(index >= a.length)
			return 0;
		if(!a[index].equals(b[index]))
			return list.indexOf(a[index])-list.indexOf(b[index]);
		return rank(a,b,index+1);
		
		
		
			
			
			
	}
	static List<String> list;
	//collate makes a String out of an array
	static String collate(String[] a) {
		String ans = "";
		for(String s: a) {
			ans+=s;
		}
		//System.out.println("ans "+ ans);
		return ans;
	}
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("manisha.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		// this will store in order A, /A, B, /B etc
		list= new ArrayList<>();
		for(int i = 0; i<26; i++) {
		
				list.add(""+(char)(i+65));
				list.add("/"+(char)(i+65));
		}
		// sorts based on the criteria
		Comparator<String> comp1 = (a,b)-> list.indexOf(a)-list.indexOf(b);
	//System.out.println(list);
	
		while(noSets-->0) {
		//arr stores the input for each line	
		String[] arr = scan.nextLine().replaceAll("\\s+","").split("\\+");
		//System.out.println(Arrays.toString(arr));
		//bigList will store the words in arr once they have been internally sorted
		List<String[]> bigList = new ArrayList<>();
		
		for(int i = 0; i<arr.length; i++) {
			String working = arr[i];
			// litList stores the words from arr one at a time broken down into letter groups (eg A or \A)
			List<String> litList = new ArrayList<>();
			for(int j = 0; j<working.length(); j++) {
				if(working.substring(j,j+1).matches("[A-Z]"))
						litList.add(working.substring(j, j+1));
				else {
					litList.add(working.substring(j,j+2));
					j++;
				}
				
				
			}
			//now sort the word
			litList.sort(comp1);
			//temp stores the words after they have been internally sorted
			String[] temp = new String[litList.size()];
			for(int k = 0; k<temp.length; k++)
				temp[k]= litList.get(k);
			//Now we add temp to bigList
			
			bigList.add(temp);
			
			
		}
		//comparators to sort bigList
		Comparator<String[]> comp2 = (a,b)-> a.length-b.length;
		Comparator<String[]> comp3 = (a,b)-> {return rank(a,b,0);};
		bigList.sort(comp2.thenComparing(comp3));
		
		String ans = "";
		
		for(String[] ss: bigList) {
			//System.out.println("ss A"+Arrays.toString(ss));
			ans+=collate(ss)+"+";
			
		}
		// cut off the last +
		System.out.println(ans.substring(0,ans.length()-1));
		
		
		
			
			
		}
		
}


}
