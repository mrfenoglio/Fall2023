import java.io.*;
import java.util.*;
public class FourQueens {
	static int noTimes = 0;// this counts the number of times there is a solution
	 
	 public static  List<List<String>> solveNQueens(int n) {
		 List<List<String>> bigList = new ArrayList<>(); // stores the answer
		 char[][] matrix = new char[n][n]; // the chessboard
		 for(int i = 0; i<matrix.length; i++) {
			  Arrays.fill(matrix[i], '.');
			 
		 }
		//  the is the backtracking algo
		bt(bigList, matrix, 0);
		 
	   
		 
		 return bigList;
	    }
	// given a matrix, can we put a queen at row r and column c
	 static boolean canUse(char[][] matrix, int r, int c) {
		 for(int i = 0; i<matrix.length; i++) {
			 if(matrix[i][c]=='Q')
				 return false;
			  }
		 
		 for(int i = 0; i<matrix.length; i++) {
			 if(matrix[r][i]=='Q')
				 return false;
			  }
		 for(int i=r,j=c; i>=0&&j<matrix.length; i--,j++) {
			 if(matrix[i][j]=='Q')
				 return false;
			 
		 }
		 for(int i=r,j=c; i>=0&&j>=0; i--,j--) {
			 if(matrix[i][j]=='Q')
				 return false;
			 
		 }
		 
		 return true;
		 
		 
	 }

// this is the key algo 
	static  void bt(List<List<String>> bigList, char[][] matrix, int row) {
		// the base case.  If we have looked at all the rows add an answer to bigList
		 if(row==matrix.length) {
			 String toAdd = "";
			 List<String> nl = new ArrayList<>();
			 for(char[] r: matrix) {
				 String s = String.join("", new String(r));
				 nl.add(s);
			 }
			 bigList.add(nl);
		
			
		noTimes++;
			 
		 }
			 //the recursive step
		 else { for(int j = 0; j<matrix.length; j++) {
			 // can we put a queen at row and col j.
			 if(canUse(matrix, row, j)) {
				 matrix[row][j]='Q';
				 bt(bigList, matrix,row+1);
				 // the back track step
				 matrix[row][j]='.';
				 
			 }
		 }
			 
			
		 }
		 
	 }
	 
	public static void main(String[] args) {
		// this is designed for multiple dims
		for(int i =4; i<5; i++) {
		List<List<String>> l =solveNQueens(i);
		System.out.println(i +" "+noTimes);
		noTimes = 0;
		System.out.println(l);
		}
		
	}

}
