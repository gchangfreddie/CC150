package Chapter2;

import java.util.HashSet;

public class Question1_LinkedListNode {
	public static void main(String[] args){
		LinkedListNode<String> node = new LinkedListNode<String>("Grace"); 
		node.add(new LinkedListNode<String>("Grace")); 
		node.add(new LinkedListNode<String>("Google")); 
		node.add(new LinkedListNode<String>("Facebook"));
		node.add(new LinkedListNode<String>("Yahoo")); 
		node.add(new LinkedListNode<String>("LinkedIn"));
		node.add(new LinkedListNode<String>("Zillow")); 
		
//		delDuplicate(node); 
		delDuplicatedItem(node);
		print(node) ; 
	}
	
	public static void print(LinkedListNode<String> head) {
		while (head!= null) {
			System.out.print(" " + head.data);
			head = head.next; 
		}
		System.out.println();
	}
	
	public static void delDuplicate(LinkedListNode<String> head  ) {
		HashSet<String> set = new HashSet<String> (); 
		LinkedListNode<String> prev = null; 
		
		while(head!=null) {
			if (set.contains(head.data)) {
				prev.next = head.next; 
			} else {
				set.add(head.data); 
				prev = head; 
			}
			head = head.next; 
		}
		
		System.out.println();
	}
	
	public static void delDuplicatedItem(LinkedListNode<String> n) {
		
		while (n.next !=null) {
			LinkedListNode<String> node = n; 
			while(node.next!=null) {
				if (n.data.equals(node.next.data)) {
					node.next = node.next.next; 
				} else {
					node = node.next; 
				}
			}
			n= n.next; 
			
		}
		System.out.println();
	}
}
