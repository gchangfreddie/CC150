package data.structure.LinkedList;

import java.util.LinkedList;

public class Question2_4_1 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("S"); 
		list.add("W"); 
		list.add("T");
		list.add("G");
		list.add("G");
		list.add("H");
		list.add("E");
		list.add("R"); 
		quickSort(list, "K");
		print(list); 
	}
	
	public static void print(LinkedList<String> list) {
		for (int i=0; i<list.size(); i++) {
			System.out.print(" " + list.get(i));
		}
		System.out.println();
	}
	
	public static void quickSort(LinkedList<String> list, String v) {
		int head = 0, end = list.size()-1; 
		while (head<=end) {
			if (list.get(head).compareTo(v) >=0) {
				String temp = list.get(end); 
				list.set(end--, list.get(head)); 
				list.set(head,  temp); 
			}else {
				head++; 
			}
		}
	}
}
