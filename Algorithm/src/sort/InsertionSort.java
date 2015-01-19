package sort;

import java.io.File;

public class InsertionSort {
	public static void sort(Comparable[] a) {
		for (int i=1; i<a.length; i++) {
			for (int j=i; j>0; j--) {
				if (a[j].compareTo(a[j-1])<0) {
					swap(a, j, j-1); 
				}else break; 
			}
		}
	}
	
	public static void swap(Comparable[] a, int i, int j){
		Comparable temp = a[i]; 
		a[i]=a[j]; 
		a[j]=temp; 
	}
	
	public static void print(File[] files){
		for (int i=0; i<files.length; i++) {
			System.out.print(files[i].getName() + " " );
		}
	}
	
	public static void main(String[] args) {
		File dir = new File("c:\\users\\grace\\downloads"); 
		File[] files = dir.listFiles(); 
		Integer[] a = new Integer[]{32,432,5,90,23,10, 22,1,-4}; 
		sort(a); 
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
 }
