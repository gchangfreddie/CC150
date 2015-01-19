package data.structure.LinkedList;

public class Question2_6 {
	public LinkedListNode findLoopBegin(LinkedListNode head) {
		LinkedListNode fast = head, slow = head; 
		
		while(fast != null && fast.next!=null) {
			slow=slow.next; 
			fast = fast.next.next; 
			if (slow==fast) break;
		}
		
		if (fast==null || fast.next==null) return null; 
		
		while(head!=slow) {
			slow = slow.next; 
			head = head.next; 
		}
		return head; 
	}
	
}
