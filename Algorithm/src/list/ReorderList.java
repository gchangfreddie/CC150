package list;

import java.util.Stack;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return; //list should have more than 3 elems
        Stack<ListNode> stack = new Stack<ListNode>(); 
        ListNode fast = head.next, slow = head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next; stack.push(slow); slow =slow.next;  
        }
        ListNode prev=null; 
        if (fast!=null) {
            prev=slow; 
            slow=slow.next;
            prev.next=null;
        }
        while(!stack.isEmpty()){
            ListNode node = stack.pop(); 
            node.next=slow; 
            slow=slow.next; 
            node.next.next=prev; 
            prev=node;
        }
    }
	
	
	public static void print(ListNode n) {
		while(n!=null) {
			System.out.print(n.val + " -> ");
			n=n.next;
		}
		System.out.println("null");
	}
	
	public static void  main(String[] args) {
		ListNode n1 = new ListNode(1); 
		ListNode n2 = new ListNode(2); n1.next=n2;
		ListNode n3 = new ListNode(3); n2.next=n3; 
		print(n1); 
		reorderList(n1);
		print(n1); 
	}
}
