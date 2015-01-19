package sort;

public class ShellSort {
	public static void sort(Comparable[] a) {
		int n = a.length; 
		int h=1; 
		while(h<n/3) h=3*h+1; 
		while(h>=1) {
			for (int i=h; i<n; i++) {
				for (int j=i; j>=h; j-=h){
					if (a[j].compareTo(a[j-h])<1) swap(a, j, j-h); 
					else break;
				}
			}
			h=h/3;
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
