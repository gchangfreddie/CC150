package com.find.a.job;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] array = new int[]{22,3,31,10,2,4,8,1,19}; 
		sort(array); 
		print(array); 
		System.exit(0);
	}
	
	private static void print(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	private static void sort(int a[]) {
		for (int i=0; i<a.length; i++) {
			int min = a[i], index = i; 
			for (int j=i+1; j<a.length; j++) {
				if (a[j] < min) {
					min = a[j]; 
					index = j; 
				}
			}
			a[index] = a[i]; 
			a[i] = min; 
		}
	}
}
