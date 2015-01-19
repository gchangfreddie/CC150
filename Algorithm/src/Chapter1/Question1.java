package Chapter1;

import java.util.*;

public class Question1 {
	
	public static void main(String[] args) {
		LinkedList<Integer> a= new LinkedList<Integer>();
//		a.add(null); 
		System.out.println(a.isEmpty());
		String s = "Aabcdefghijklmnopqrstuvwxyz";
		System.out.println(s);
		System.out.println(isUniqueString(s));
		System.exit(0);
	}
	
	public static void chang(String s) {
		s = ""; 
	}
	
//	private static boolean isUniqueString(String s) {
//		BitSet b = new BitSet(256); 
//		
//		for (int i=0; i<s.length(); i++) {
//			int a = s.charAt(i)%256; 
//			if(b.get(a)) return false; 
//			b.set(a);
//		}
//		
//		return true; 
//	}
	
	private static boolean isUniqueString(String s) {
		long checker = 0; 
		
		for (int i=0; i<s.length(); i++) {
			int a =s.charAt(i)%97 ; 
			if (a==0)
			System.out.println(a);
			if ((checker & (long)(1<<a)) != 0) 
				return false; 
			checker |= (1<<a); 
		}
		
		return true; 
	}
}
