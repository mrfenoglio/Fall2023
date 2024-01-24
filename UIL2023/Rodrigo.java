import java.io.*;
import java.util.*;
public class Rodrigo {
	// this method returns the index of the unvisited city
	// currently closest (prices) to Dallas
	
	static int lowest(boolean[] visited, int[] prices) {
		int ans = -1;
		int min = Integer.MAX_VALUE;
		for(int i= 0; i<visited.length; i++) {
			if(!visited[i] && min>prices[i]) {
				ans = i;
				min = prices[i];
			}
		}
	
		return ans;
	}
	// this method populates prices.  When done it returns the minimal prices from Dallas to a city
	static int[] find(String start, Map<String, Integer>map, int[][] adj) {
		int[] prices = new int[adj.length];
		Arrays.fill(prices, Integer.MAX_VALUE);
		// we are starting in Dallas
		int dal = map.get("Dallas");
		prices[dal]=0;
		
		boolean[] visited = new boolean[prices.length];
		
		
		for(int i = 0; i<prices.length; i++) {
			// find the lowest unvisited price
			int check = lowest(visited, prices);
		// check to see if we're done
			if(check==-1)
				return prices;
			// check is the city with the lowest remaining price
			visited[check]= true;
			// key algo.  update prices.
			for(int k = 0; k<prices.length; k++) {
				if(k!=dal && adj[check][k]!=0&& !visited[k]) {
					prices[k]= Math.min(prices[k], prices[check]+adj[check][k]);
				}
			}
			//System.out.println(Arrays.toString(prices));
			
		
			
				
			
		}
		return prices;
		
	}
	
	public static void main(String[] args) throws IOException{
		List<city> list = new ArrayList<>();
		Scanner scan = new Scanner(new File("rodrigo"));
				int cities = scan.nextInt();
				int flights = scan.nextInt();
				int  index = 0;
				int budget = scan.nextInt();
				Map<String, Integer> map = new HashMap<>();
				for(int i = 0; i<cities; i++) {
					String name = scan.next();
					double rating = scan.nextDouble();
					double price = scan.nextDouble();
					int att = scan.nextInt();
					double cul = scan.nextDouble();
					map.put(name, index++);
					list.add(new city(name, rating, price, att, cul, index-1));
					
					
					
				}
				map.put("Dallas", index);
int[][] adj = new int[cities+1][cities+1];
int n = flights;
while(n-->0) {
	String left = scan.next();
	String right = scan.next();
	//System.out.println(left+" "+ right);
	int price = scan.nextInt();
	
	//System.out.println(map);
	
	adj[map.get(left)][map.get(right)]=price;
	adj[map.get(right)][map.get(left)]=price;
	
}

// now we need to find prices from Dallas;
int[] prices = find("Dallas", map, adj);
for(int i = prices.length-1; i>=0; i--) {
	if(prices[i]>2000)
		list.remove(i);
}
Comparator<city> comp1 = (a,b)->b.att-a.att;
Comparator<city> comp2 = (a,b)->b.culinary-a.culinary>0?1:b.culinary-a.culinary<0? -1:0;
Comparator<city> comp3 = (a,b)->b.price-a.price>0?1:b.price-a.price<0? -1:0;
Comparator<city> comp4 = (a,b)->b.rating-a.rating>0?1:b.rating-a.rating<0? -1:0;
list.sort(comp1.thenComparing(comp2).thenComparing(comp3).thenComparing(comp4));
for(city c: list)
	System.out.println(c.name);
}
}
	class city{
		String name;
		double rating;
		double price;
		int att;
		double culinary;
		int index;
		public city(String name, double rating, double price, int att, double culinary, int ind) {
			super();
			this.name = name;
			this.rating = rating;
			this.price = price;
			this.att = att;
			this.culinary = culinary;
			index = ind;
		}
	}
			
