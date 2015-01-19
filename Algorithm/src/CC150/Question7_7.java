package CC150;

import java.util.ArrayList;
import java.util.LinkedList;

public class Question7_7 {
	
	public static void main(String[] args){
		System.out.println(findNum(10));
	}
	
	private static int findNum(int k) {
		LinkedList<Integer> alist = new LinkedList<Integer>(); 
		int index = 0; 
		alist.add(index, 1);
		
		while (index<k) {
			int n = alist.remove(); 
			index++; 
			if (index == k) return n; 
			insert(n*3, alist);
			insert(n*5, alist); 
			insert(n*7, alist); 
		}
		
		return -1; 
	}
	
	private static void insert(int a, LinkedList<Integer> list) {
		if (list.size() == 0) {
			list.add(a);
			return; 
		}
		if (list.contains(a)) return; 
		LinkedList<Integer> l = new LinkedList<Integer>(); 
		int i= list.size()-1; 
		while (list.get(i) > a) {
			l.addFirst(list.remove(i--));
		}
		list.add(i+1, a); 
		if (l.size()>0) list.addAll(i+2, l); 
	}
}
