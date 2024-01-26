
import java.util.*;

import java.io.*;

public class S {
	public static int lowercase(String[][] ar, int x, int y) {

		int count = 0;

		if (ar[x][y].equals("r")) {
			if (x + 1 < 8 && y - 1 >= 0) {
				if (ar[x + 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x + 1][y - 1].equals("b")) {
					if (x + 2 < 8 && y - 2 >= 0 && ar[x+2][y-2].equals("_")) {
						count++;
					}
				}
			} 
			if (x + 1 < 8 && y + 1 < 8) {
				if (ar[x + 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x + 1][y + 1].equals("b")||ar[x + 1][y + 1].equals("B")) {
					if (x + 2 < 8 && y + 2 < 8 &&ar[x+2][y+2].equals("_")) {
						count++;
					}
				}
			}
		} else if (ar[x][y].equals("b")) {
			if (x - 1 >= 0 && y - 1 >= 0) {
				if (ar[x - 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y - 1].equals("r")||ar[x - 1][y - 1].equals("R")) {
					if (x - 2 >= 0 && y - 2 >= 0&&ar[x - 2][y - 2].equals("_")) {
						count++;
					}
				}
			} if (x - 1 >= 0 && y + 1 < 8) {
				if (ar[x - 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y + 1].equals("r")||ar[x - 1][y + 1].equals("R")) {
					if (x - 2 >= 0 && y + 2 < 8 && ar[x - 2][y + 2].equals("_")) {
						count++;
					}
				}
			}
		}

		return count;

	}

	public static int uppercase(String[][] ar, int x, int y) {

		int count = 0;

		if (ar[x][y].equals("R")) {
			if (x + 1 < 8 && y - 1 >= 0) {
				if (ar[x + 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y - 1].equals("b")||ar[x - 1][y - 1].equals("B")) {
					if (x + 2 < 8 && y - 2 >= 0) {
						count++;
					}
				}
			}  if (x + 1 < 8 && y + 1 < 8) {
				if (ar[x + 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x + 1][y + 1].equals("b")||ar[x + 1][y + 1].equals("B")) {
					if (x + 2 < 8 && y + 2 < 8 && ar[x+2][y+2].equals("_")) {
						count++;
					}
				}
			}  if (x - 1 >= 0 && y - 1 >= 0) {
				if (ar[x - 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y - 1].equals("b")||ar[x - 1][y - 1].equals("B")) {
					if (x - 2 >= 0 && y - 2 >= 0&&ar[x-2][y-2].equals("_")) {
						count++;
					}
				}
			}  if (x - 1 >= 0 && y + 1 < 8) {
				if (ar[x - 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y + 1].equals("b")||ar[x - 1][y - 1].equals("B")) {
					if (x - 2 >= 0 && y + 2 < 8 && ar[x-2][y+2].equals("_")) {
						count++;
					}
				}
			}
		} else if (ar[x][y].equals("B")) {
			if (x + 1 < 8 && y - 1 >= 0) {
				if (ar[x + 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x + 1][y - 1].equals("r")||ar[x + 1][y - 1].equals("R")) {
					if (x + 2 < 8 && y - 2 >= 0&&ar[x+2][y-2].equals("_")) {
						count++;
					}
				}
			}  if (x + 1 < 8 && y + 1 < 8) {
				if (ar[x + 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x + 1][y + 1].equals("r")||ar[x - 1][y - 1].equals("R")) {
					if (x + 2 < 8 && y + 2 < 8&&ar[x+2][y+2].equals("_")) {
						count++;
					}
				}
			}  if (x - 1 >= 0 && y - 1 >= 0) {
				if (ar[x - 1][y - 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y - 1].equals("r")||ar[x - 1][y - 1].equals("R")) {
					if (x - 2 >= 0 && y - 2 >= 0&&ar[x-2][y-2].equals("_")) {
						count++;
					}
				}
			}  if (x - 1 >= 0 && y + 1 < 8) {
				if (ar[x - 1][y + 1].equals("_")) {
					count++;
				} else if (ar[x - 1][y + 1].equals("r")||ar[x - 1][y + 1].equals("R")) {
					if (x - 2 >= 0 && y + 2 < 8 && ar[x-2][y+2].equals("_")) {
						count++;
					}
				}
			}

		}

		return count;
	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new File("svetlana.dat"));
		int x = scan.nextInt();
		scan.next();
		int caseNo = 1;
		while (x-- > 0) {
			System.out.println("Test case: "+ caseNo++);
			scan.nextLine();

			String[][] arr = new String[8][8];

			for (int aaa = 0; aaa < 8; aaa++) {
				arr[aaa] = scan.nextLine().trim().split("\\s+");
			}

//			for (String[] p : arr) {
//				System.out.println(Arrays.toString(p));
//			}

			int count = 0;

			for (int i = 0; i < arr.length; i++) {
				for (int a = 0; a < arr[i].length; a++) {
					if (arr[i][a].equals("r")) {
						count += lowercase(arr, i, a);
						//System.out.println("col "+a+" row " +i +"count "+ count);
					} else if (arr[i][a].equals("R")) {
						
						count += uppercase(arr, i, a);
					}
				}
			}

			System.out.println("Red valid single moves: "+count);
			count = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int a = 0; a < arr[i].length; a++) {
					if (arr[i][a].equals("b")) {
						count += lowercase(arr, i, a);
						//System.out.println("col "+a+" row " +i +"count "+ count);
					} else if (arr[i][a].equals("B")) {
						count += uppercase(arr, i, a);
					}
				}
			}
			
			System.out.println("Black valid single moves: "+count);

		}

	}
}