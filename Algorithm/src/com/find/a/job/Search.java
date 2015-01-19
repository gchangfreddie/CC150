package com.find.a.job;

public class Search {
	
	public static void main (String[] args) {
		int[] a = new int[]{8, 22, 31, 42, 53, 104, 134}; 
		
		int index = search(a, 0, a.length-1,22); 
		System.out.println(index);
		System.exit(0);
	}
	
	public static int search(int[] a, int s, int e, int v) {
		if (s>e) return -1; 
		int m = s+(e-s)/2; 
		if (a[m] == v) return m; 
		if (a[m]<v) return search(a, m+1, e, v); 
		return search(a, s, m-1, v) ; 
	}
	
	public static int search1(int[] a, int s, int e, int v) {
		while (s>e) {

			int m = s+(e-s)/2; 
			if (a[m] == v) return m; 
			if (a[m]<v) s=m+1; 
			else e=m-1; 
		}
		return -1; 
	}
}
