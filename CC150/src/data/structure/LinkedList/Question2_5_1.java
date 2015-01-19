package data.structure.LinkedList;

public class Question2_5_1 {
	
	public static void main(String[] args) {

		LinkedListNode s1 = new LinkedListNode(4); 
		s1.add(new LinkedListNode(8)); 
		s1.add(new LinkedListNode(7));
		s1.add(new LinkedListNode(9));
		LinkedListNode s2 = new LinkedListNode(3); 
		s2.add(new LinkedListNode(9)); 
		s2.add(new LinkedListNode(5));
		s2.add(new LinkedListNode(8));
		s2.add(new LinkedListNode(2));
		
//		LinkedListNode res = add(s1, s2, 0); 
		LinkedListNode res = addReverse(s1, s2, new IntWrapper()); 
		print(res); 
	}
	
	public static LinkedListNode add(LinkedListNode l1, LinkedListNode l2, int carry) { 
		if (l1 == null && l2 == null && carry == 0) 
			return null;  
		
		LinkedListNode n3 = new LinkedListNode(carry); 
		
		int value = carry ;
		if (l1!=null) value += l1.d; 
		if (l2!= null) value += l2.d; 
		
		n3.d = value %10; 
		
		n3.next = add(l1 !=null ? l1.next:null, l2 != null ? l2.next: null, value/10); 
		return n3; 
	}
	
	public static void print(LinkedListNode head){
		while (head!=null) {
			System.out.print(" "+head.d);
			head = head.next; 
		}
		System.out.println();
	}
	
	public static LinkedListNode addReverse(LinkedListNode l1, LinkedListNode l2, IntWrapper iw) {
		if (l1==null && l2 == null) {
			return null; 
		}
		int len1 = checkLen(l1);
		int len2 = checkLen(l2); 
		if (len1 > len2) {
			l2 = padding (l1, l2, len1, len2);  
		}
		else l1 = padding (l2, l1, len2, len1);  
			
		LinkedListNode node = new LinkedListNode(0); 
		node.next = addReverse(l1.next, l2.next, iw);
		node.d = (l1.d + l2.d + iw.value) %10; 
		iw.value = (l1.d + l2.d + iw.value) /10; 
		
		return node; 
	}
	
	public static int checkLen(LinkedListNode n) {
		int len = 0; 
		while(n!=null) {
			len++;
			n= n.next;
		}
		return len; 
	}
	
	public static LinkedListNode padding(LinkedListNode l1, LinkedListNode l2, int len1, int len2){
		int times = len1-len2; 
		LinkedListNode start = l2; 
		while (times> 0) {
			LinkedListNode node = new LinkedListNode(0); 
			node.next = start; 
			start = node; 
			times--; 
		}
		return start; 
	}
	
}

class IntWrapper{
	int value; 
}
