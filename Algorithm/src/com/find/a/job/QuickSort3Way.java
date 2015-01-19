package com.find.a.job;

public class QuickSort3Way {

		public static void main(String[] args) {
			int[] a = new int[]{12,17,2,11,8,4,9,1,6}; 
			sort(a);
			print(a); 
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
			int lt = low, gt = high, i = lt+1;  // lt and gt are 2 moving pointer pointing to the less than and greater than item.
			int v  = a[low]; 
			while (i<=gt){
				if (a[i]<v) {
					swap(a, i, lt);
					i++; lt++; 
				} else if (a[i]>v) {
					swap(a, i, gt); 
					gt--; 
				} else {
					i++; 
				}
			}
			if (gt<high) sort(a, gt+1, high) ;  //must check gt and lt are not overflow
			if (lt>low) sort(a, low, lt-1); 
		}
}
