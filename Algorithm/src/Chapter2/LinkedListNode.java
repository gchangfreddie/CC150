package Chapter2;

public class LinkedListNode<K> {
	K data; 
	LinkedListNode<K> next; 
	int size ; 
	
	public LinkedListNode(K v) {
		data = v;
		next = null; 
		size = 1; 
	}
	
	public void add(LinkedListNode<K> node) {
		LinkedListNode<K> n = this; 
		while (n.next != null) {
			n = n.next;
		}
		n.next = node; 
		size++; 
	}
	
	public void remove(K v) {
		LinkedListNode<K> n = this; 
		while(n.next != null ) {
			if (n.next.data.equals(v)) {
				n.next = n.next.next; 
				size--; 
				break; 
			}
			n = n.next;
		}
	}

}
