package data.structure.LinkedList;

public class LinkedListNode {
	LinkedListNode next; 
	String data; 
	int d; 
	
	public LinkedListNode remove(LinkedListNode node) {
		if (node.data.equals(this.data)) {
			return this.next; 
		}
		LinkedListNode runner = this.next;
		while(runner.next !=null) {
			if (runner.next.data.equals(node.data)) {
				runner.next = runner.next.next; 
				return this;  
			} 
			runner= runner.next; 
		}
		return this; 
	}
	
	public void add(LinkedListNode node) {
		if (next == null ) {
			this.next = node;
			return;
		}
		LinkedListNode temp = this.next; 
		while (temp.next!=null) {
			temp = temp.next; 
		}
		temp.next = node; 
	}
	
	public LinkedListNode(String data) {
		this.data = data; 
	}
	
	public LinkedListNode(int d) {
		this.d = d; 
	}
}
