package data.structure.LinkedList;

import java.util.LinkedList;
import java.util.Stack;

public class Question2_7 {
	
	public static void main(String[] args){
//		LinkedList<Character> cl = new LinkedList<Character>(); 
//		cl.add('p'); 
//		cl.add('e'); 
//		cl.add('e'); cl.add('w'); cl.add('e'); cl.add('e'); cl.add('p'); 
//		
//		Question2_7 q = new Question2_7(); 
//		System.out.println(q.isPalindrome(cl));
		
		LinkedListNode lln = new LinkedListNode("p"); 
		lln.add(new LinkedListNode("e")); 
		lln.add(new LinkedListNode("e"));
//		lln.add(new LinkedListNode("w"));
		lln.add(new LinkedListNode("e"));
		lln.add(new LinkedListNode("e"));
		lln.add(new LinkedListNode("p"));
		Question2_7 q = new Question2_7(); 
		System.out.println(q.isPalindrome(lln));
	}

	public boolean isPalindrome(LinkedList<Character> l) {
		if (l.isEmpty()) return false; 
		int ei = l.size()-1; 
		for (int si=0; si<l.size()/2; si++) {
			if (l.get(si) != l.get(ei)) return false; 
			ei--; 
		}
		return true; 
	}

	public boolean isPalindrome(LinkedListNode l) {
		LinkedListNode fr = l, sr = l;
		Stack<String> s = new Stack<String>(); 
		while (fr != null && fr.next != null) {
			s.push(sr.data); 
			sr = sr.next;
			fr = fr.next.next;
		}
		if (fr != null)  {
			sr = sr.next;
		}
		while (sr != null) {
			if (!sr.data.equals(s.pop())) return false; 
			sr = sr.next; 
		}
		return true; 
	}
	
	public LinkedListNode isPalindrome(LinkedListNode l, int length) {
		if (length ==0 || length ==1) {
			return l.next; 
		}
		LinkedListNode n = isPalindrome(l.next, length-2); 
		if (l.data.equals(n.data)) return n.next; 
		else return null; 
	}
}
