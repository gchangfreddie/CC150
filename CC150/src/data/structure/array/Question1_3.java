package data.structure.array;

import java.util.Arrays;
import java.util.HashMap;

public class Question1_3 {
	public boolean solution(String s1, String s2) {
		if (s1.length() != s2.length()) return false; 
		
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(); 
		Arrays.sort(c1); Arrays.sort(c2); 
		return (new String(c1)).equals(new String(c2)); 
//		return (Arrays.equals(c1, c2)); 
	}

	public static void main(String[] args) {
		Question1_3 q = new Question1_3(); 
		
		System.out.println(q.solution1("abcade", "egcdab"));
	}
	
	public boolean solution1(String s1, String s2) {
		if (s1.length() != s2.length()) return false; 
		char[] c1=s1.toCharArray(), c2 = s2.toCharArray(); 
		
		HashMap h1 = new HashMap<Character, Integer>(),
			h2 = new HashMap<Character, Integer>();
		
		insert(h1, s1); insert(h2, s2); 
		return (h1.equals(h2)); // compare each item of the map
	}
	
	private void insert(HashMap<Character, Integer> h, String s) {
		for (int i=0; i<s.length(); i++) {
			Character c = s.charAt(i); 
			if (h.containsKey(c)) {
				h.put(c, h.get(c) +1); 
			} else {
				h.put(c, 1); 
			}
		}
	}
}
