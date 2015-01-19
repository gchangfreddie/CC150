package data.structure.Recursion;

import java.util.ArrayList;
import java.util.*;

public class Question9_5 {
	
	public static ArrayList<String> permutation(String a, int index) {
		ArrayList<String> res = new ArrayList<String>(); 
		
		if (a.length()==1) res.add(a); 
		else {
			ArrayList<String> strList = permutation(a.substring(index+1), 0); 
			String b = a.substring(index, index+1); 

			for (String str: strList) {
				for (int i=0; i<=str.length(); i++) {
					StringBuffer sb = new StringBuffer(); 
					sb.append(str.substring(0, i)).append(b);
					if (i<a.length()) sb.append(str.substring(i)); 
					res.add(sb.toString()); 
				}
			}
		}
		return res; 

	}
	
	public static void main(String[] args) {
		ArrayList<String> list = permutation("GrGG", 0); 
		
		Set<String> set = new HashSet<String>(); 
		for (String str: list) {
			System.out.println(str);
			set.add(str); 
		}
		
		System.out.println(set.size());
		
	}
}
