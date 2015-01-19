package data.structure.moderate;

public class SortMN {
	public int[] sortmn(int[] a) {
		int[] res = new int[2]; 
		int m=0, n=a.length-1; 
		for (int i=0; i<a.length-1; i++) {
			for (int j=i+1; j<a.length&&m==0; j++) {
				if (a[i]>a[j]) {
					m=i; break; 
				}
			}
		}
		for (int i=a.length-1; i>0; i--) {
			for (int j=i-1; j>=0&&n==a.length-1; j--) {
				if (a[i]<a[j]) {
					n=i; break; 
				}
			}
		}
		res[0] = m; 
		res[1] = n; 
		return res; 
	}
	
	static int shrinkLeft(int[] a, int min_index, int start)	{
		for (int i=start; i>=0; i--) {
			if (a[i]<a[min_index]) return i+1; 
		}
		return 0; 
	}
	
	static int shrinkRight(int[] a, int max_index, int start) {
		for (int i=start; i<a.length; i++) {
			if (a[i]>a[max_index]) return i-1; 
		}
		return a.length-1; 
	}
	
	static void find(int[] a) {
		int endLeft = findEndOfLeft(a); 
		int startRight = findStartOfRight(a); 
		int min=endLeft; 
		int max=startRight; 
		for (int i=endLeft; i<=startRight; i++) {
			if (a[i]>a[max]) max=i; 
			if (a[i]<a[min]) min=i; 
		}
		int m = shrinkLeft(a, min, endLeft); 
		int n = shrinkRight(a, max, startRight); 
		
		System.out.println(m + " " + n);
	}
	
	static int findEndOfLeft(int[] a){
		for (int i=0; i<a.length-1; i++) {
			if (a[i]>a[i+1]) return i;
		}
		return a.length-1; 
	}
	
	static int findStartOfRight(int[] a) {
		for (int i=a.length-1; i>0; i--) {
			if (a[i]<a[i-1]) return i ;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SortMN smn = new SortMN(); 
		int[] a = new int[]{1,2,4,7,10, 11, 7, 16, 18, 19}; 
		find(a);
		int[] res = smn.sortmn(a);
		for (int i: res) {
			System.out.println(i);
		}
	}
}
