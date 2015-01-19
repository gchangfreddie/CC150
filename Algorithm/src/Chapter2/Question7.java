package Chapter2;

import java.util.Stack;

public class Question7 {

	public boolean isPalindrome(LinkedListNode<String> head) {
		LinkedListNode fast = head, slow = head; 
		
		Stack<Object> s = new Stack<Object>(); 
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next; 
			s.push(slow.data); 
			slow = slow.next; 
		}
		
		while(slow!=null) {
			if (!slow.data.equals(s.pop())) return false;
			slow= slow.next; 
		}
		return true; 
	}
	
	public static LinkedListNode<String> isPRecursive(LinkedListNode<String> head, int length, BoolWrapper isP) {
		if (length == 1) {
			isP.value = true; 
			return head.next; 
		}
		if (length == 2) {
			if (head.data.equals(head.next.data)) isP.value = true;
			else 
				isP.value = false;
			return head.next.next; 
		}
		LinkedListNode<String> node = isPRecursive(head.next, length-2, isP); 
		if (!isP.value || !head.data.equals(node.data)  ) 
			isP.value = false; 
		else isP.value = true; 
		return node.next; 
	}
	
	public static void main(String[] args){
		
		LinkedListNode lln = new LinkedListNode("p"); 
		lln.add(new LinkedListNode("e")); 
		lln.add(new LinkedListNode("a"));
		lln.add(new LinkedListNode("w"));
		lln.add(new LinkedListNode("a"));
		lln.add(new LinkedListNode("e"));
		lln.add(new LinkedListNode("p"));
		BoolWrapper bw = new BoolWrapper(); 
		isPRecursive(lln, 7,bw); 
		System.out.println(bw.value);
		System.exit(0);
	}
	
}
class BoolWrapper {
	boolean value; 
}