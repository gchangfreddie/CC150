package Chapter1;

import java.util.Arrays;

public class Question3 {

	public static void main(String[] args) {
		String s1 = new String("grace google carge eloogg"); 
		String s2 = new String("google ggaaeerr goocc gle"); 
		
		System.out.println(compare(s1, s2));
		System.out.println(compareH(s1, s2));
		System.exit(0);
	}
	
	public static boolean compare(String s1, String s2) {
		if (s1 != null && s2 != null) {
			if (s1.length() != s2.length() ) return false;
			else {
				char[] c1 =s1.toCharArray(); 
				char[] c2 = s2.toCharArray(); 
				Arrays.sort(c1);
				Arrays.sort(c2);
				return String.valueOf(c1).equals(String.valueOf(c2)) ; 
			}
		} else if (s1 == null && s2 == null ) return true; 
		return false; 
	}
	
	public static boolean compareH(String s1, String s2) {
		if (s1.length() != s2.length()) return false; 
		int[] ac = new int[256]; 
		for (int i=0; i<s1.length(); i++) {
			char c = s1.charAt(i); 
			ac[c]++; 
		}
		for (int i=0; i<s2.length(); i++) {
			char c = s2.charAt(i); 
			ac[c]--;
			if (ac[c] <0) return false; 
			
		}
		return true; 
	}
}
