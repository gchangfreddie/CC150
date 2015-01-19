package Chapter1;

import java.util.Scanner;

public class Question7 {
	public static void main(String[] args) {
		int[][] a = new int[5][6]; 
		int[] row = new int[5]; 
		int[] column = new int[6]; 
		
		Scanner s = new Scanner(System.in); 
		s.useDelimiter(","); 
		int m=0,n=0; 
		while (s.hasNext() && m<5) {
			a[m][n++] = s.nextInt(); 
			if (n==6) {
				m++; n=0; 
			}
		}
		
		for (int i=0 ; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				if (a[i][j] == 0) {
					row[i] = 1; 
					column[j] = 1; 
				}
			}
		}
		System.out.println();
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				if (row[i] == 1 || column[j]==1)
					a[i][j] =0;
			}
		}
		
		for (int i=0 ; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}
	}
}
