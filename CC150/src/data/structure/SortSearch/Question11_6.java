package data.structure.SortSearch;

public class Question11_6 {
	public static void main(String[] args){
		int[][] a = new int[4][5];

		a = build(4, 5); 
		print (a); 
//		int[] res = search(a, 3); 
//		System.out.println(res[0] + "  " +  res[1]); 
		System.out.println(find(a,9)); 
	}
	
	private static boolean find(int[][]a, int t) {
		int r = 0, c = a[0].length-1; 
		while (r<a.length && c>=0) {
			int v = a[r][c]; 
			if (v==t) 
				return true; 
			if (t<v) c--; 
			else r++; 
		}
		return false; 
	}

	public static int[][] build (int ii, int jj) {
		int[][] temp = new int[ii][jj]; 
		for (int i = 0; i<ii; i++) {
			int t =1; 
			for (int j=0 ; j<jj;  j++) {
				temp[i][j] = i+t; 
				t++; 
			}
		}
		return temp;
	}

	private static void print(int[][] a) {
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	private static int[] search(int[][]a, int t) {
		int row = a.length, col = a[0].length; 
		for (int i=0; i<row; i++) {
			int j=0; 
			while (j<col-1) {
				if(a[i][j] == t) return new int[]{i, j}; 
				if (a[i][j+1] == t ) return new int[]{i, j+1};
				if (a[i][j]> t) return new int[]{-1, -1}; 
				if (a[i][j]<t){
					if (a[i][j+1] <t) {
						j++;  continue; 
					} else{
						for (int m=i; m<row; m++ ){
							if (a[m][j] == t) return new int[] {m, j}; 
						}
						return new int[]{-1, -1}; 
					}
				}

			}
		}
		return new int[]{-1, -1}; 
	}
}