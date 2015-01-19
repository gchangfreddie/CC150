package data.structure.SortSearch;

public class Question11_3 {
	public static void main(String[] args) {
		int[] b = new int[]{34,45,56, 100, 1,3,6,7,13,16,19,23};
		int e = 34; 
//		int[] b = new int[] {2,2,2,3,4,2}; 
		System.out.print(find(b,0, b.length-1, e));
		
	}
	
	private static int find(int[] a, int s, int e, int t){
		if (s>e) return -1; 
		int m = s + (e-s)/2; 
		int v = a[m]; 
		if (t==v) return m; 
		
		if (v < a[s]){ 
			if (v<=t && t<=a[e]) return find(a, m+1, e, t); 
			else return find(a, s, m-1, t); 
		} else if (v>a[s]) {
			if (a[s]<=t && t<= v) return find(a, s, m-1, t); 
			else return find(a, m, e, t ); 
		} else { //v==a[s]
			if (v==a[e]) {
				int i = find(a, s, m-1, t); 
				if (i==-1) return find(a, m+1, e, t); 
				else return i; 
			} else {
				return find(a, m+1, e, t); 
			}
		}
	}	
	
	private static int bst(int[] a, int s, int e, int t) {
		if (s>e) return -1; 
		int m = s+ (e-s)/2; 
		int v = a[m]; 
		if (t==v) return m; 
		if (t<v) return bst(a, s, m-1, t); 
		else return bst(a, m+1, e, t); 
	}
}
