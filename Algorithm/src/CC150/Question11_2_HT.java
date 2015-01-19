package CC150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Question11_2_HT {
	public static void main(String[] args) {
		String[] a = new String[]{"grace", "gogle", "facebook", "linked", "amazon", "racge", "bookface", "liednk"}; 
		
		hashTable(a); 
		print(a); 
	}
	
	private static void print(String[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}
	
	private static String sort(String s){
		char[] c = s.toCharArray(); 
		Arrays.sort(c);
		return new String(c); 
	}
	
	private static void hashTable(String[] a) {
		Hashtable<String, List<String>> ht = new Hashtable<String, List<String> >(); 
		for (String ss: a) {
			String s = sort(ss); 
			List<String> l; 
			if (!ht.containsKey(s)) {
				ht.put(s,new ArrayList<String>() ); 
			}
			l = ht.get(s); 
			l.add(ss); 
			
		}
		int j=0; 
		Enumeration<List<String>> e = ht.elements(); 
		while(e.hasMoreElements()) {
			List<String> l= e.nextElement(); 
			for (String s:l) {
				a[j++] = s; 
			}
		}
	}
}
