package sort;

import java.io.File;

public class SelectionSort {
	public static void sort(Comparable[] a){
		for (int i=0; i<a.length-1; i++) {
			int min=i;
			for (int j=i+1; j<a.length; j++) {
				if (a[j].compareTo(a[min])<0) 
					min= j;
			}
			if (min!=i) swap(a, min, i); 
		}
	}
	
	public static void swap(Comparable[] a, int i, int j){
		Comparable temp = a[i]; 
		a[i]=a[j]; 
		a[j]=temp; 
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{32,432,5,90,23,10, 22,1,-4}; 
		sort(a); 
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
