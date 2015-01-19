package data.structure.StackQueue;

public class StackG {
	Node top; 
	
	public void add(Node n) {
		if (top == null) top = n; 
		else {
			n.next = top; 
			top = n; 
		}
	}
	
	public Node pop() {
		if (top == null) return null; 
		else {
			Node result= top; 
			top = top.next; 
			result.next =null; 
			return result; 
		}
	}
	
	public boolean isEmpty() {
		return top == null; 
	}
	
	public Node peek() {
		return top; 
	}
	
	public static void main(String[] args) {
//		Stack s = new Stack();
		Queue s = new Queue(); 
		s.add(new Node("Grace")); 
		s.add(new Node("Cindy")); 
		s.add(new Node("Sarah")); 
		s.add(new Node("Angie")); 
		
		for (int i=0; i<4; i++) {
			System.out.println(s.remove().s + "  ");
		}
	}
}
