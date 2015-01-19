package com.find.a.job;

public class InsertSort {

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
		
		private static void sort(int[] a) {
			for (int i=1; i<a.length; i++) {
				for (int j=i; j>0 && (a[j-1] > a[j]); j--) {
					swap(a, j-1, j); 
				}
				
			}
		}
		
		private static void swap(int[] a, int i, int j) {
			int temp = a[i]; 
			a[i] = a[j]; 
			a[j] = temp; 
		}
}
