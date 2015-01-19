package list;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head==null || head.next==null) return head;
		ListNode slow = head, fast = head.next;
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next; 
			slow = slow.next; 
		}
		ListNode temp = slow.next; 
		slow.next = null; 
		return merge(sortList(head), sortList(temp)); 
	}

	public ListNode merge(ListNode n1, ListNode n2){
		ListNode res = new ListNode(0); 
		ListNode run = res; 
		while(n1!=null && n2!=null) {
			if (n1.val<n2.val){
				run.next = n1; 
				n1=n1.next;
			} else {
				run.next=n2; 
				n2=n2.next;
			}
			run=run.next;
		}
		run.next = n1!=null ? n1 : n2;
		return res.next; 
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
