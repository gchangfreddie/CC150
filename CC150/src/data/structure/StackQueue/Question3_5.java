package data.structure.StackQueue;

public class Question3_5 {
	public StackG s1, s2 ; 
	
	public Question3_5() {
		s1 = new StackG(); 
		s2 = new StackG(); 
	}
	public void add(String a) {
		s1.add(new Node(a)); 
	}
	
	public String remove() {
		if (s1==null) return null; 
		while(!s1.isEmpty()) {
			s2.add(s1.pop()); 
		}
		String result = s2.pop().s;
		while(!s2.isEmpty()) {
			s1.add(s2.pop()); 
		}
		return result; 
	}
	
	public String peek() {
		if (s1==null) return null;
		return s1.peek().s; 
	}
	
	public static void main(String[] args) {
		Question3_5 q =new Question3_5(); 
		q.add("a"); 
		q.add("b"); 
		q.add("c"); 
		q.add("d"); 
		q.add("e"); 
		for (int i=0;i<5; i++) {
			System.out.println(q.remove());
		}
		
//		for (int i=0; i<5; i++) {
//			System.out.println(q.remove());
//		}
	}
}
