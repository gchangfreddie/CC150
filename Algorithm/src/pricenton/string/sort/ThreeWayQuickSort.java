package pricenton.string.sort;

public class ThreeWayQuickSort {
	
	public static void sort(String[] a) {
		sort(a, 0, a.length-1, 0); 
	}

	public static void sort(String[] a, int low, int high, int d) {
		if (low>=high ) return ;
		int c = charAt(a[low], d); 
		int lt = low, gt = high, i=lt+1; 
		while(i<=gt) {
			if (charAt(a[i],d)<c) 
				swap(a, i++, lt++); 
			else if (charAt(a[i],d)>c) 
				swap(a, i, gt--); 
			else i++; 
		}
		sort(a, low, lt-1, d); 
		if (c>0) sort(a, lt, gt, d+1); 
		sort(a, gt+1, high, d); 
	}
	
	private static int charAt(String s, int i) {
		if (i<s.length()) return s.charAt(i); 
		else return -1; 
	}
	
	public static void swap(String[] arr, int a, int b) {
		String temp = arr[a]; 
		arr[a] = arr[b]; 
		arr[b] = temp; 
	}
	
	public static void main(String[] args) {
//		String[] a = new String[]{"d", "d", "e", "a", "c", "b", "d", "f"}; 
		String[] a = new String[]{"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
		sort(a); 
		for (String str : a) {
			System.out.print(str + "  ");
		}
		System.exit(0);
	}
}
