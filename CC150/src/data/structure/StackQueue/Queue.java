package data.structure.StackQueue;

public class Queue {
	Node first; 
	
	public void add (Node n) {
		if (first == null) {
			first=n; 
		} else {
			Node next = first; 
			while (next.next != null) {
				next = next.next; 
			}
			next.next = n; 
		}
	}
	
	public Node remove() {
		if (first==null) return null; 
		Node result = first; 
		first = first.next;
		return result; 
	}
	
	public Node get() {
		return first; 
	}
}

class Node {
	String s; 
	String min; 
	Node next; 
	
	public Node(String s) {
		this.s = s; 
		this.min = s; 
	}
}