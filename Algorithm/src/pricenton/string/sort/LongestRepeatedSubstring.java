package pricenton.string.sort;

import java.util.Arrays;

public class LongestRepeatedSubstring {
	public static String solution(String s) {
		String[] suffix = new String[s.length()]; 
		for (int i=0; i<s.length(); i++) {
			suffix[i] = s.substring(i);
		}
		Arrays.sort(suffix);
		String res = ""; 
		for (int i=0; i<suffix.length-1; i++){
			int temp  = lcp(suffix[i], suffix[i+1]); 
			if (temp>res.length()) res = suffix[i].substring(0, temp); 
		}
		return res; 
	}
	
	private static int lcp(String s1, String s2) {
		int n = Math.min(s1.length(), s2.length()); 
		for (int i=0; i<n; i++) {
			if (s1.charAt(i)!=s2.charAt(i)) return i; 
		}
		return n; 
	}
	
	public static void main(String[] args) {
		System.out.println(solution("twinstwins"));
	}
}
