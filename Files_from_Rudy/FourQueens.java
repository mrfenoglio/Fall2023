import java.io.*;
import java.util.*;
public class FourQueens {
	static int noTimes = 0;
	 //static List<List<Integer>> bigList = new ArrayList<>();
	 public static  List<List<String>> solveNQueens(int n) {
		 List<List<String>> bigList = new ArrayList<>();
		 char[][] matrix = new char[n][n];
		 for(int i = 0; i<matrix.length; i++) {
			  Arrays.fill(matrix[i], '.');
			 
		 }
		
		bt(bigList, matrix, 0);
		 
	   
		 
		 return bigList;
	    }
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
	static  void bt(List<List<String>> bigList, char[][] matrix, int row) {
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
		 else { for(int j = 0; j<matrix.length; j++) {
			 if(canUse(matrix, row, j)) {
				 matrix[row][j]='Q';
				 bt(bigList, matrix,row+1);
				 matrix[row][j]='.';
				 
			 }
		 }
			 
			
		 }
		 
	 }
	 
	public static void main(String[] args) {
		for(int i =4; i<5; i++) {
		List<List<String>> l =solveNQueens(i);
		System.out.println(i +" "+noTimes);
		noTimes = 0;
		System.out.println(l);
		}
		
	}

}
