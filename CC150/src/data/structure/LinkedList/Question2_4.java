package data.structure.LinkedList;

public class Question2_4 {
	
	public LinkedListNode solution(LinkedListNode l, String v) {
		if (l == null || l.next == null) return null;
		
		LinkedListNode s = l, r = s; 
		while(r.next!=null) {
			if (r.next.data.compareTo(v)<0) {
				LinkedListNode temp = r.next; 
				r.next = r.next.next; 
				temp.next = s;
				s = temp; 
			} else {
				r = r.next; 
			}
		}
		return s; 
		 
	}
	
	
	public LinkedListNode solution2(LinkedListNode l, String v) {
		if (l==null || l.next==null) return null; 
		
		LinkedListNode before=null, after=null, n=l; 
		
		while(n != null) {
			LinkedListNode temp = n.next; 
			if (n.data.compareTo(v) >= 0) {
				n.next = after; 
				after = n; 
			} else {
				n.next = before; 
				before = n; 
			}
			n = temp; 
		}
		
		if (before == null) return after; 
		LinkedListNode temp = before;
		while (temp.next!= null) {
			temp = temp.next; 
		}
		temp.next = after; 
		return before; 
	}
	
	public static void main(String[] args) {
		LinkedListNode lln = new LinkedListNode("Start"); 
		lln.add(new LinkedListNode("W")); 
		lln.add(new LinkedListNode("T"));
		lln.add(new LinkedListNode("Grace"));
		lln.add(new LinkedListNode("Go"));
		lln.add(new LinkedListNode("H"));
		lln.add(new LinkedListNode("End"));
		LinkedListNode node = new LinkedListNode("R"); 
		lln.add(node);
		
		LinkedListNode n = lln; 
		while(n!=null) {
			System.out.print(n.data + " ");
			n=n.next; 
		}
		System.out.println();
		
		Question2_4 q = new Question2_4(); 
		LinkedListNode temp = q.iterateReverse(lln); 
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp=temp.next; 
		}

	    n = q.solution2(lln, "Job"); 
//	    n=lln; 
		while(n!=null) {
			System.out.print(n.data + " ");
			n=n.next; 
		}
	}
	
	public LinkedListNode iterateReverse(LinkedListNode s) {
		if (s==null || s.next == null) return s; 
		
		LinkedListNode n2nd = s.next, n3rd = n2nd.next; 
		
		n2nd.next = s; s.next = null; 
		LinkedListNode prev = n2nd, cur = n3rd; 
		while (cur.next != null) {
			LinkedListNode temp = cur.next; 
			cur.next = prev; 
			prev = cur; 
			cur = temp; 
		}
		cur.next = prev; // append the last node
		return cur; 
	}

	public LinkedListNode reverse(LinkedListNode s) {
		LinkedListNode n = s.next; 
		if (n.next ==null) {
			n.next = s;
			return n;
		}
		LinkedListNode h = reverse(n); 
		n.next = s;
		s.next = null; // this is important, otherwise there is a loop like a.next -> b and b.next -> to a. 
		return h; 
	}
	
}

class Cat{
	int length; 
	public Cat(int l){
		length = l; 
	}
}
