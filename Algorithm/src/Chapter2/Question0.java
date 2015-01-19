package Chapter2;

import java.awt.print.Printable;

public class Question0 {

public static void main(String[] args){
		
		LinkedListNode<String> lln = new LinkedListNode<String>("a"); 
		lln.add(new LinkedListNode<String>("c")); 
		lln.add(new LinkedListNode<String>("e"));
		lln.add(new LinkedListNode<String>("g"));
		lln.add(new LinkedListNode<String>("b"));
		lln.add(new LinkedListNode<String>("d"));
		lln.add(new LinkedListNode<String>("f"));
		lln.add(new LinkedListNode<String>("h"));
		switchN(lln);
		print(lln); 
		System.exit(0);
	}

	public static void switchN(LinkedListNode<String> node) {
		LinkedListNode<String> fast = node, s = node; 
		
		while(fast!=null) {
			fast=fast.next.next; 
			s = s.next; 
		}
		
		fast = node; 
		LinkedListNode<String> temp = s.next;
		while (temp!=null) {
			s.next = fast.next; 
			fast.next = s; 
			fast = s.next; 
			s = temp; 
			temp = temp.next;
		}
		fast.next = s; 
	}
	
	
	
	public static void print(LinkedListNode<String> n) {
		while (n!=null) {
			System.out.print(n.data + "  ");
			n = n.next;
		}
		System.out.println();
	}
}
