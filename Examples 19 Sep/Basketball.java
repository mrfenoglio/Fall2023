import java.io.*;
import java.util.*;
public class Basketball {
	String team;
	int wins;
	int loses;
	
	

public Basketball(String team, int wins, int loses) {
		super();
		this.team = team;
		this.wins = wins;
		this.loses = loses;
	}

static List<Basketball> list = new ArrayList<>();
static void adjWin(String str) {
	for(Basketball t: list) {
		if(t.team.equals(str)) {
			t.wins+=1;
			break;
		}
			
	}
	
}
static void adjLos(String str) {
	for(Basketball t: list) {
		if(t.team.equals(str)) {
			t.loses+=1;
			break;
		}
			
	}
	
}
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("basketball.dat"));
		int noSets = scan.nextInt();
		int league = 1;
		scan.nextLine();
		while(noSets-->0) {
			list = new ArrayList<>();
			String[] teams = scan.nextLine().split("\\s+");
			for(String s: teams)
				list.add(new Basketball(s,0,0));
			int games = scan.nextInt();
			while(games-->0) {
				String left = scan.next();
				String right = scan.next();
				String winner = scan.next();
				String loser = left.equals(winner)? right: left;
				adjWin(winner);
				adjLos(loser);
			}
			Comparator<Basketball> comp = (a,b)->{if (b.wins!=a.wins)
				return b.wins-a.wins;
			else 
				return a.team.compareToIgnoreCase(b.team);
			};
			
			list.sort(comp);
			System.out.println("League #"+league++ +":");
			for(Basketball b: list)
				System.out.println(b.team +" "+b.wins+":"+b.loses);
			
			
		}
		
}
}
