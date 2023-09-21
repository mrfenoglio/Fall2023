import java.io.*;
import java.util.*;
public class Words {
	static List<Character> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("words.dat"));
			int noSets = scan.nextInt();
			int caseNo = 1;
			Comparator<String> len = (a,b)->b.length()-a.length();
			Comparator<Character> ch = (a,b)->Collections.frequency(list, b)-Collections.frequency(list, a);
		scan.nextLine();
			while(noSets-->0) {
				System.out.println("Case #"+caseNo+".");
				String[] arr = scan.nextLine().replaceAll("\\W&&[^ ]","").split("\\s+");
				Arrays.sort(arr,len);
				System.out.println("Longest: "+arr[0]);
				System.out.println("Shortest: "+arr[arr.length-1]);
				caseNo++;
				list = new ArrayList<>();
				String all = "";
				for(String s: arr)
					all+=s;
				all = all.toLowerCase();
				for(int i = 0;i<all.length(); i++ )
					list.add(all.charAt(i));
				list.sort(ch);
				System.out.println("Letter: "+ list.get(0));
				
			}
			
			
			
			
	}

}
