package Chapter2;

import java.util.*;

public class Question1 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(); 
//		list.add("a"); list.add("b"); list.add("c"); list.add("a"); list.add("d"); list.add("b"); list.add("grace") ; 
		
		Scanner s = new Scanner(System.in); 
		s.useDelimiter(","); 
		
		while (s.hasNext()) {
			list.add(s.next()); 
			if (list.size() >5) break; 
		}
		print(list); 
//		solution(list);
		Hashtable<String, Boolean> ht = new Hashtable<String, Boolean>(); 
		LinkedList<String> tempList = (LinkedList<String>)list.clone(); 
		
		for (int i=0; i<list.size(); i++) {
			if (ht.containsKey(list.get(i))) 
				list.remove(i); 
			else ht.put(list.get(i), true); 
		}
		print(list); 
		System.exit(0);
	}
	
	public static void print(List<String> list) {
		for (String str : list) System.out.print("  " + str);
		System.out.println();
	}
	
	public static void solution(List<String> l) {
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
}
