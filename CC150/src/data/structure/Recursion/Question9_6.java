package data.structure.Recursion;

import java.util.*;

public class Question9_6 {

	
	public static void main(String[] args) {
//		Set<String> s = print(5); 
		ArrayList<String> s = generateParens(5); 
		for (String ss  :s){
			System.out.println(ss);
		}
		System.out.println(s.size());
		
		
	}
	
	public static Set<String> print(int remaining) {
		Set<String> set = new HashSet<String>(); 
		if (remaining ==0) set.add(""); 
		else {
			Set<String> prev = print(remaining-1) ; // here could NOT use set, that will cause a CurrentModificationException
			for (String s : prev) {
				for (int i=0; i<s.length(); i++) {
//					if (s.charAt(i)=='(') {
						String left = s.substring(0, i+1); 
						String right = s.substring(i+1, s.length()); 
						String ts = left + "()" + right; 
						set.add(ts); 
//					}
				}
				if (!set.contains("()"+ s)) {
					set.add("()"+s); 
				}
			}
		}
		return set; 
	}
	
	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count*2]; 
		ArrayList<String> list = new ArrayList<String>(); 
		addParen(list, count, count, str, 0); 
		return list; 
	}
	
	public static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int count) {
		if (leftRem<0 || rightRem <0) {
			return; 
		}
		if (leftRem ==0 && rightRem ==0) {
			String s = String.copyValueOf(str);
			list.add(s); 
		} else {
			if (leftRem > 0) {
				str[count] = '('; 
				addParen(list, leftRem-1, rightRem, str, count+1); 
			}
			if (rightRem > leftRem) {
				str[count] = ')'; 
				addParen(list, leftRem, rightRem-1, str, count+1); 
			}
		}
	}
}
