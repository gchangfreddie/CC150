package data.structure.SortSearch;

public class Question11_1 {

	public static void main(String[] args) {
		int[] aO = new int[]{3,4,8,9,11,23}; 
		int[] b = new int[]{1,3,6,7,13,16,19,23};
		
		int[] a = new int[aO.length + b.length]; 
		for (int i=0; i<aO.length; i++) a[i] = aO[i]; 
		mergeSort(a, b, aO.length-1, aO.length + b.length-1); 
		print(a); 
		
	}
	
	private static void mergeSort(int[] a, int[] b, int i, int c){
		int j = b.length-1; 
		while(i>=0 && j>=0) {
			while(j>=0 &&b[j]>a[i]) { 
				a[c] = b[j];  
				c--; j--; 
			}
			while(i>=0 &&a[i]>=b[j]) {
				a[c] = a[i]; 
				c--; i--; 
			}
		}
		// we need not copy a since they are already in place
		while(j>=0) a[c--] = b[j--]; 
	}	
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
}
