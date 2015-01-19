package data.structure.LinkedList;

public class Question2_2 {
	public LinkedListNode solution(LinkedListNode n, int k){
		LinkedListNode runner = n; 
		int i=1; 
		
		while (i<k ) {
			runner=runner.next;
			if (runner==null) return null; 
			i++; 
		}
		LinkedListNode kthNode = n; 
		while(runner.next!= null) {
			runner = runner.next; 
			kthNode = kthNode.next; 
		}
		return kthNode; 
	}
	
	public static void main(String[] args) {
		LinkedListNode lln = new LinkedListNode("start"); 
		lln.add(new LinkedListNode("2nd")); 
		lln.add(new LinkedListNode("3rd"));
		lln.add(new LinkedListNode("4th"));
		lln.add(new LinkedListNode("5th"));
		lln.add(new LinkedListNode("6th"));
		lln.add(new LinkedListNode("7th"));
		lln.add(new LinkedListNode("end"));
		
		Question2_2 q = new Question2_2(); 
		LinkedListNode result = q.solution(lln, -1);
		if (result != null)	System.out.println(result.data);
	}
	
	
}
