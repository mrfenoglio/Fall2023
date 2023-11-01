import java.util.*;
import java.time.*;
import java.io.*;
import java.time.format.*;
public class Isabel {
	public static void isabel() throws IOException{
		Scanner scan  = new Scanner(new File("isabel.dat"));
		ArrayList<String> names = new ArrayList<String>();
		int [][] dates;
		ArrayList<Integer> y = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		
		while (scan.hasNextLine()) {
			names.add(scan.next());
			y.add(scan.nextInt());
			m.add(scan.nextInt());
			d.add(scan.nextInt());
		}
		dates = new int[names.size()][3];
		for (int i = 0; i < names.size(); i++) {
			dates[i][0] = y.get(i);
			dates[i][1] = m.get(i);
			dates[i][2] = d.get(i);
		}
		LocalDate[] locdate = new LocalDate[names.size()];
		DateTimeFormatter form = DateTimeFormatter.ofPattern("eeee, MMMM dd, yyyy");
		for (int i = 0; i < names.size(); i++) {
			locdate[i] = LocalDate.of(dates[i][0], dates[i][1], dates[i][2]);
		}
		int[] dow = new int[names.size()];
		for (int i = 0; i < names.size(); i++) {
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 20)).getDayOfWeek())) {
				dow[i] = 0;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 21)).getDayOfWeek())) {
				dow[i] = 1;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 22)).getDayOfWeek())) {
				dow[i] = 2;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 23)).getDayOfWeek())) {
				dow[i] = 3;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 24)).getDayOfWeek())) {
				dow[i] = 4;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 25)).getDayOfWeek())) {
				dow[i] = 5;
			}
			if (locdate[i].getDayOfWeek().equals((LocalDate.of(2023, 8, 26)).getDayOfWeek())) {
				dow[i] = 6;
			}
		} 
		for (int i = 0; i < names.size() - 1; i++) {
			for (int j = 1; j < names.size(); j++) {
				if (dow[i] > dow[j]) {
					LocalDate tempd = locdate[i];
					locdate[i] = locdate[j];
					locdate[j] = tempd;
					String temps = names.get(i);
					names.set(i, names.get(j));
					names.set(j, temps);
				}
				if (dow[i] == dow[j]) {
					if (names.get(i).compareTo(names.get(j)) > 0) {
						LocalDate tempd = locdate[i];
						locdate[i] = locdate[j];
						locdate[j] = tempd;
						String temps = names.get(i);
						names.set(i, names.get(j));
						names.set(j, temps);
					}
					else if (names.get(i).compareTo(names.get(j)) < 0) {
						LocalDate tempd = locdate[i];
						locdate[i] = locdate[j];
						locdate[j] = tempd;
						String temps = names.get(i);
						names.set(i, names.get(j));
						names.set(j, temps);
					}
				}
			}
		}
		for (int i = 0; i < names.size(); i++) {
			System.out.printf("%-12s: ", names.get(i));
			System.out.println(locdate[i].format(form));
		}
	}
}
