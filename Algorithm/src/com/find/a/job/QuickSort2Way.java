package com.find.a.job;

public class QuickSort2Way {
	public static void main(String[] args) {
		int[] a = new int[]{12,17,2,11,8,4,9,1,6}; 
		sort(a);
		print(a); 
		System.exit(0);
	}
	
	private static void sort(int[] a) {
		sort(a, 0, a.length-1); 
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	
	private static void sort(int[] a, int low, int high) {
		int i=low+1, j=high; 
		int v = a[low]; 
		while (i<=j) {
			while(i<=high && a[i] <v) { //must be <=, not <
				i++; 
			} 
			while(j>=low && a[j]> v){ //must be >=, not >
				j--; 
				
			}
			if (i>j) break; 
			swap(a, i, j);
			i++; j--; 
		}
		if (j>low) swap(a, j, low); // must check j is not overflow
		if (j>low) sort(a, low, j-1); 
		if (j<high) sort(a, j+1, high); 
	}
}
