import java.io.*;
import java.util.*;
public class Rodrigo {
	
	static int lowest(boolean[] visited, int[] prices) {
		int ans = -1;
		int min = Integer.MAX_VALUE;
		for(int i= 0; i<visited.length; i++) {
			if(!visited[i] && min>prices[i])
				ans = i;
				min = prices[i];
			 
		}
		
		return ans;
	}
	static int[] find(String start, Map<String, Integer>map, int[][] adj) {
		int[] prices = new int[adj.length];
		Arrays.fill(prices, Integer.MAX_VALUE);
		int dal = map.get("Dallas");
		prices[dal]=0;
		
		boolean[] visited = new boolean[prices.length];
		
		//Queue<Integer>queue = new LinkedList<>();
		//queue.add(dal);
		for(int i = 0; i<prices.length; i++) {
			int check = lowest(visited, prices);
			System.out.println(check);
			if(check==-1)
				return prices;
			visited[check]= true;
			for(int k = 0; k<prices.length; k++) {
				if(k!=dal && adj[check][k]!=0) {
					prices[k]= Math.min(prices[k], prices[check]+adj[check][k]);
				}
			}
			System.out.println(Arrays.toString(prices));
			
		
			
				
			
		}
		return prices;
		
	}
	
	public static void main(String[] args) throws IOException{
		List<city> list = new ArrayList<>();
		Scanner scan = new Scanner(new File("rodrigo"));
				int cities = scan.nextInt();
				int flights = scan.nextInt();
				int budget = scan.nextInt();
				for(int i = 0; i<cities; i++) {
					String name = scan.next();
					double rating = scan.nextDouble();
					double price = scan.nextDouble();
					int att = scan.nextInt();
					double cul = scan.nextDouble();
					list.add(new city(name, rating, price, att, cul));
					
					
					
				}
int[][] adj = new int[cities+1][cities+1];
Map<String, Integer> map = new HashMap<>();
int n = flights;
int  index = 0;
while(n-->0) {
	String left = scan.next();
	String right = scan.next();
	//System.out.println(left+" "+ right);
	int price = scan.nextInt();
	if(!map.containsKey(left))
		map.put(left, index++);
	if(!map.containsKey(right))
		map.put(right, index++);
	//System.out.println(map);
	
	adj[map.get(left)][map.get(right)]=price;
	adj[map.get(right)][map.get(left)]=price;
	
}
for(int[] row: adj)
	System.out.println(Arrays.toString(row));
// now we need to find prices from Dallas;
int[] prices = find("Dallas", map, adj);
System.out.println(map);
System.out.println(Arrays.toString(prices));
}
}
	class city{
		String name;
		double rating;
		double price;
		int att;
		double culinary;
		public city(String name, double rating, double price, int att, double culinary) {
			super();
			this.name = name;
			this.rating = rating;
			this.price = price;
			this.att = att;
			this.culinary = culinary;
		}
	}
			
