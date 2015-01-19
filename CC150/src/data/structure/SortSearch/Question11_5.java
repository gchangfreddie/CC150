package data.structure.SortSearch;

import java.util.Arrays;


public class Question11_5 {

	public static void main(String[] args){
		String[] a = new String[]{"book", "", "", "ce", "", "face", "", "", "", "goo", "", "gra", "linkedIn","", "zillow", ""}; 
		Arrays.asList(a).iterator();
		System.out.println(find(a, 0, a.length-1, "zillow"));
		String s1="Monday";
		String s2 ="Monday"; 
		System.out.println(s1==s2);
		
	}
	
	private static int find(String[] a, int s, int e, String t) {
		if (s>e) return -1;
		int m = s+ (e-s)/2; 
		String v = a[m]; 
		int n=m;
		String w = v; 
		while (w.isEmpty() && n<=e) {
			w=a[n++]; 
		}
		if (n>e&&w.equals("")) return find(a, s, m-1, t); 
		if (w.equals(t)){
			return n-1; 
		} else if (w.compareTo(t)>0) {
			return find(a,s, m-1, t); 
		} else return find (a, n+1,e,  t); 
		
	}
}
