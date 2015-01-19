package com.find.a.job;

public class ShellSort {
	public static void main(String[] args) {
		int[] array = new int[]{22,3,31,10,2,4,8,1,19,12,7,5,16}; 
		sort(array); 
		print(array); 
		System.exit(0);
	}
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	private static void sort(int[] a) {
		int n = a.length; 
		int gap = 1; 
		while (gap<n/3) gap = gap*3 +1; // if n < 6, gap is 1, otherwise gap is 4, and 13 etc
		while (gap>=1){ // until gap==1
			// this is insertion sort
			for (int i=gap; i<n; i++) {
				for (int j=i; j>=gap && (a[j-gap] > a[j]); j-=gap) {
					swap(a, j-gap, j); 
				}
			}
			gap =gap/3; 
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}
}
