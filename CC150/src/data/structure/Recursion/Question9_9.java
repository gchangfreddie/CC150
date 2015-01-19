package data.structure.Recursion;

import java.util.ArrayList;

public class Question9_9 {
	public static ArrayList<int[]> result = new ArrayList<int[]>(); 

	public static void EightQueens(int[] rowArray, int rowIndex) {
		// base case
		if (rowIndex == 8) {
			result.add(rowArray.clone()); 
			return; 
		}
		for (int i=0; i<8; i++) {
			int j; 
			for (j=0; j<rowIndex; j++) {
				if ((rowArray[j] == i)||((rowIndex-j) == Math.abs(i-rowArray[j]))) 
					break; 
			}
			if (j==rowIndex) { // i is a valid place for rowIndex row
				rowArray[rowIndex] = i; 
				EightQueens(rowArray, rowIndex+1); 
			}	
		}
	}	
	
	public static void main(String[] args){
		int[] array = new int[8]; 
		EightQueens(array, 0); 
		for (int i=0; i<result.size(); i++) {
			int[] a = result.get(i); 
			for (int j=0; j<a.length; j++) {
				System.out.print((a[j]+1) + " ");
			}
			System.out.println();
		}
		System.out.println(result.size());
	}
	
}
