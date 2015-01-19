package data.structure.LinkedList;

public class Question2_3 {
	public void solution(LinkedListNode n) {
		if (n.next == null) {
			n= null; 
			return; 
		}
		n.data = n.next.data; 
		n.next = n.next.next; 
	}
	
	public static void main(String[] args) {
		LinkedListNode lln = new LinkedListNode("start"); 
		lln.add(new LinkedListNode("2nd")); 
		lln.add(new LinkedListNode("3rd"));
		lln.add(new LinkedListNode("5th"));
		lln.add(new LinkedListNode("6th"));
		lln.add(new LinkedListNode("7th"));
		lln.add(new LinkedListNode("end"));
		LinkedListNode node = new LinkedListNode("4th"); 
		lln.add(node);
		LinkedListNode n = lln; 
		while(n!=null) {
			System.out.print(n.data + " ");
			n=n.next; 
		}
		System.out.println();
		Question2_3 q = new Question2_3(); 
		q.solution(node); 

	    n = lln; 
		while(n!=null) {
			System.out.print(n.data + " ");
			n=n.next; 
		}
	}
}
