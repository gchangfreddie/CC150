package CC150;

import java.util.Arrays;
import java.util.Comparator;

public class Question11_2 {
	public static void main(String[] args) {
		String[] a = new String[]{"grace", "gogle", "facebook", "linked", "amazon", "racge", "bookface", "liednk"}; 
		
		sort(a, 0, a.length-1); 
		print(a); 
	}
	
	private static void print(String[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	
	private static void sort(String[] a, int l, int h) {
		Comparator<String> c = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return sort(s1).compareTo(sort(s2)); 
			}
		};
		Arrays.sort(a, c);
//		if (h<=l) return; 
//		int lt = l, i=lt+1, gt=h;
//		while (i<=gt) {
//			int r = c.compare(a[i], a[lt]); 
//			if (r<0) {
//				swap(a, i, lt); i++; lt++; 
//			} else if (r>0) {
//				swap(a, i, gt); gt--; }
//			else i++; 
//		}
//				
//		sort(a, l, lt-1); 
//		sort(a, gt+1, h); 
		
	}
	
	private static void swap(String[] a, int i, int j) {
		String temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp; 
	}
	
	private static String sort(String s) {
		char[] c = s.toCharArray(); 
		Arrays.sort(c);
		return String.copyValueOf(c); 
	}
}
