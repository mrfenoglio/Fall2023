import java.io.*;
import java.util.*;
import java.time.*;
public class Isabel {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("isabel.dat"));
		
		List<Birthday> births = new ArrayList<>();
		Comparator<Birthday> dayComp = (a, b) -> a.birth.getDayOfWeek().getValue()-b.birth.getDayOfWeek().getValue(); // to sort by day of the week
		Comparator<Birthday> nameComp = (a, b) -> a.name.compareTo(b.name); // to sort by first name
		
		while (scan.hasNext())
		{
			String[] in = scan.nextLine().split(" ");
			String name = in[0];
			int year = Integer.parseInt(in[1]);
			int month = Integer.parseInt(in[2]);
			int day = Integer.parseInt(in[3]);
			
			births.add(new Birthday(year, month, day, name));	
		}
		
		births.sort(dayComp.thenComparing(nameComp)); // sort by day of the week, then sort by first name to break ties
		for (Birthday b: births)
		{
			//System.out.println("-----------!");
			System.out.printf("%-11s: ", b.name);
			System.out.println(b);
		}
	}
}

class Birthday {
	LocalDate birth;
	String dayOfWeek;
	String monthName;
	String name;
	
	public Birthday(int year, int month, int day, String n)
	{
		birth = LocalDate.of(year, month, day);
		dayOfWeek = birth.getDayOfWeek().name().charAt(0) + birth.getDayOfWeek().name().substring(1).toLowerCase(); // convoluted way of matching output (ex. "THURSDAY" -> "Thursday")
		monthName = birth.getMonth().name().charAt(0) + birth.getMonth().name().substring(1).toLowerCase(); // same as above, but for the month
		name = n;
		
	}
	
	public String toString()
	{
		return dayOfWeek + ", " + monthName + " " + birth.getDayOfMonth() + ", " + birth.getYear();
	}
}
