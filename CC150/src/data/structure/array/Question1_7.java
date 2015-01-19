package data.structure.array;

public class Question1_7 {
	public static void main(String[] args) {
		Question1_7 q = new Question1_7(); 
		int[][] matrix = new int[5][8]; 
		buildMatrix(matrix, 8, 5); 
		printMatrix(matrix, 8, 5); 
		q.set(matrix); 
		System.out.println();
		printMatrix(matrix, 8, 5); 
		
	}
	
	private void setZero(int[][] matrix) {
		boolean[] row = new boolean[matrix.length]; 
		boolean[] col = new boolean[matrix[0].length]; 
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				if (matrix[i][j]==0) {
					col[j]=true; 
					row[i]=true;
				}
			}
		}
		
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
			if (row[i] || col[j] ) {
					matrix[i][j] = 0; 
				}
				
			}
		}
	}

	private static void buildMatrix(int[][] matrix, int n, int m) {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = (int)(Math.abs(i-j)*Math.random()*10 ); 
			}
		}
	}
	
	private static void printMatrix(int[][] matrix, int n, int m) {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public static void set(int[][] array) {
		int m=array.length, n=array[0].length; 
		int row = 0, col =0; 
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (array[i][j]==0) {
					row |= 1<<i; 
					col |= 1<<j;
				}
			}
		}
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if ((row & 1<<i) !=0 || (col & 1<<j) !=0) {
					array[i][j]=0; 
				}
			}
		}
	}
}
