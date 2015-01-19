package data.structure.LinkedList;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Question2_1 {
	public void solution(List<String> l) {
//		HashSet s = new HashSet<String>(l); 
		HashMap<String, String> h = new HashMap<String, String>(); 
		for (int i=0; i<l.size(); i++) {
			if (h.containsKey(l.get(i))) {
				l.remove(i); 
			} else {
				h.put(l.get(i), l.get(i)); 
			}
		}
				
	}
	
	public void solution1(List<String> l) {
		for (int i=0; i<l.size()-1; i++) {
			for (int j=i+1; j<l.size(); j++) {
				if (l.get(j).equals(l.get(i))) {
					l.remove(j); 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>(); 
		l.add("a"); l.add("b"); l.add("c"); l.add("a"); l.add("d"); l.add("b"); l.add("grace") ; 
		
		new Question2_1().solution1(l); 
		
		for (int i=0; i<l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
	}
}
