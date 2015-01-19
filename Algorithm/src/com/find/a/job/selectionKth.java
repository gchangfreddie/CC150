package com.find.a.job;

public class selectionKth {
	public static void main(String[] args) {
		int[] a = new int[]{12,17,2,11,8,4,9,1,6}; 
		int number = select(a,2); 
		System.out.println(number);
		System.exit(0);
	}
	
	private static int select(int[] a, int k) {
		int l=0, h = a.length-1; 
		while(l<h) {
			int j = partition(a, l, h, k); 
			if (j==k) return a[j]; 
			if (j<k) l = j+1; 
			else h = j-1; 
		}
		return a[k]; 
	}
	
	private static int partition(int[] a, int s, int e, int k) {
		int i = s+1, j= e, v = a[s]; 
		while (i<=j) {
			while (i<=e && a[i]<v) i++; //must be i<=e, otherwise for {6,5,4,3,2,1}, we get {2,5,4,3,6,1}
			while (a[j]>v) j--; 
			if (i>j) break; 
			swap(a, i, j); 
			i++; j--; 
		}
		swap(a, s, j);
		return j; 
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}
}
