package com.find.a.job;

public class MergeSort {
	public static void main(String[] args) {
		int[] array = new int[]{22,3,31,10,2,4,8,1,19}; 
		array = sort(array); 
		print(array); 
		System.exit(0);
	}
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	private static int[] sort(int[] array){
		int[] b = new int[array.length]; 
		b =  array.clone(); 
		sort(array, b, 0, array.length-1); 
		return b; 
	}
	
	private static void sort(int[] a, int[] b, int s, int e){
		if (e<=s) return; 
		
		int m = s + (e-s)/2; 
		sort(b, a, s, m); 
		sort(b, a, m+1, e); 
		merge(b, a, s, m, e); 
	}
	
	private static void merge(int[] b, int[] a, int s, int m, int e) {
		int i = s, j = m+1; // j should = m+1 rather than m; 
		
		for (int k=s; k<(e+1); k++) { //k should start from s, not 0
			if (i>m) b[k] = a[j++] ; 
			else if (j>e) b[k] = a[i++]; 
			else if (a[i]<a[j]) b[k] = a[i++]; 
			else b[k] = a[j++]; 
		}
	}
	
	
}
