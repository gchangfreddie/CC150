package data.structure.StackQueue;

public class Question3_2 {
	public static void main(String[] args) {
		StackMin s = new StackMin();
		s.push(new Node("Grace")); 
		s.push(new Node("Cindy")); 
		s.push(new Node("Sarah")); 
		s.push(new Node("Angie")); 
		
		System.out.println(s.min());
		s.pop(); 
		System.out.println(s.min());
		s.pop(); 
		System.out.println(s.min());
		s.pop(); 
		System.out.println(s.min());
		
	}
	
	

}

class StackMin {
	Node top;
	
	public void push(Node n) {
		if (top == null) {
			top = n; 
		} else {
			n.next = top; 
			if (top.min.compareTo(n.min) < 0 ) {
				n.min = top.min; 
			}
			top = n; 
		}
	}
	
	public Node pop() {
		Node result = top; 
		top = top.next; 
		return result; 
	}
	
	public String min() {
		return top.min; 
	}
}