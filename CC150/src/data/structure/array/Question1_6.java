package data.structure.array;

public class Question1_6 {
	
	public void solution(int[][] matrix, int n) {
		for (int layer=0; layer<n/2; ++layer) {
			int first = layer; // the first index of layer i 
			int last = n-1-layer; // the last index of layer i
			for (int j= first; j<last; j++) {
				int offset = j-first; 
				int top = matrix[first][j]; 
				matrix[first][j] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset]; 
				matrix[last][last-offset] = matrix[j][last]; 
				matrix[j][last] = top; 
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		buildMatrix(matrix, 4);
		printMatrix(matrix, 4); 
		Question1_6 q = new Question1_6(); 
		q.solution(matrix, 4); 
		System.out.println();
		printMatrix(matrix, 4); 
	}

	private static void buildMatrix(int[][] matrix, int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = (int)(Math.abs(i-j)*Math.random()*10); 
			}
		}
	}
	
	private static void printMatrix(int[][] matrix, int n) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}

}
