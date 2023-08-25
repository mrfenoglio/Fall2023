import java.io.*;
import java.util.*;

public class Logan {
	List<Bag> bagsUsed = new ArrayList<>();
	int maxVal = 0;
	int capacityUsed = Integer.MAX_VALUE;
	
	void solve(List<Bag> bags, int capacityLeft, int capacityUsed, int val, List<Bag> ans, int i) {
		if (capacityLeft < 0) // terminate if we go over max weight; invalid combination (not sure if this is actually necessary, but why not)
			return;
		
		if (capacityLeft >= 0 && val > maxVal) // check if our current ans has made a higher value combination than what we already have
		{
			maxVal = val;
			bagsUsed = ans;
			this.capacityUsed = capacityUsed;
		}
		if (i < bags.size())
		{
			solve(bags, capacityLeft, capacityUsed, val, ans, i+1); // don't use current bag
			
			List<Bag> toUse = new ArrayList<>(); // make new list to preserve contents of ans (for some reason does not work if we just send ans into the method)
			toUse.addAll(ans);
			toUse.add(bags.get(i));
			
			solve(bags, capacityLeft-bags.get(i).weight, capacityUsed + bags.get(i).weight, val+bags.get(i).val, toUse, i+1); // use current bag
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("logan.dat"));
		int numSets = Integer.parseInt(scan.nextLine());
		
		while (numSets-- > 0)
		{
			int maxWeight = Integer.parseInt(scan.nextLine());
			int numBags = Integer.parseInt(scan.nextLine());
			
			List<Bag> bags = new ArrayList<>();
			
			for (int i = 0; i < numBags; i++)
			{
				String[] bag = scan.nextLine().split(" ");
				bags.add(new Bag(Integer.parseInt(bag[0]), Integer.parseInt(bag[1]), bag[2]));
			}
			
			Logan ans = new Logan();
			ans.solve(bags, maxWeight, 0, 0, new ArrayList<>(), 0);
			
			System.out.println(maxWeight);
			System.out.println(ans.capacityUsed);
			System.out.println("$" + ans.maxVal);
			for (Bag b : ans.bagsUsed)
				System.out.println(b);		
		}
	}
}

// to store bag properties easier
class Bag {
	int val;
	int weight;
	String color;
	
	public Bag(int v, int w, String c)
	{
		val = v;
		weight = w;
		color = c;
	}
	
	public String toString()
	{
		return color;
	}
}
