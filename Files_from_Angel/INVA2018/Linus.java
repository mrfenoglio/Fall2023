import java.util.*;
import java.io.*;
public class Linus {
	public static void linus() throws IOException {
		Scanner scan = new Scanner(new File("linus.dat"));
		int repeat = scan.nextInt();
		for (int r = 0; r < repeat; r++) {
			int n = scan.nextInt();
			int d = scan.nextInt();
			int w = 0;
			if (n == d) {
				w = n/d;
				System.out.println(w);
			}
			else {
				if (n > d) {
					w = n/d;
					n = n%d;
				}
				for (int i = n; i > 1; i--) {
					if (n%i == 0 && d % i == 0) {
						n /=i;
						d /= i;
					}
				}
				if (w != 0) {
					System.out.println(w + " " + n + "/" + d);
				}
				else {
					
						System.out.println(n + "/" + d);
				}
			}
		}
	}
}
