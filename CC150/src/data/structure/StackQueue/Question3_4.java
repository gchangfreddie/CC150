package data.structure.StackQueue;

import java.util.Stack;

public class Question3_4 {
	Stick<Integer>  b; 
	int counter =0; 
	
	Question3_4() {
		b = new Stick<Integer> ("B");
	}
	
	public static void main(String[] args) {
		Question3_4 q = new Question3_4(); 
		
		Stick<Integer> s = new Stick<Integer>("A"); 
		s.push(9); 
		s.push(8); 
		s.push(7); 
		s.push(6); 
		
		Stick<Integer> s1 = new Stick<Integer>("C"); 
		s.move(s1, q.b, s.size()); // this is Object-oriented
		
		while(!s1.isEmpty()) {
			System.out.println(" " + s1.pop());
		}
		System.out.println(q.counter);
		
	}

}

class Stick<Integer>{
	Stack<Integer> s; 
	String name; 
	
	public String toString() {
		return name; 
	}
	
	public Stick(String name) {
		this.name = name;
		s = new Stack<Integer>(); 
	}
	
	public Integer pop() {
		return s.pop(); 
	}
	
	public void push(Integer o) {
		s.push(o); 
	}
	
	public int size() {
		return s.size(); 
	}
	
	public boolean isEmpty() {
		return s.isEmpty(); 
	}
	
	public void move(Stick<Integer> des, Stick<Integer> buffer, int s) {
		if (s == 1) {
			moveOneStep(des);
			return; 
		}
		move(buffer, des, s -1 );
		moveOneStep(des);
		buffer.move(des, this, s -1); 
		
	}
	
	private void moveOneStep(Stick<Integer> b) {
		Integer item = pop(); 
		b.push(item);
		System.out.println("move " + item + " from " + this + " to " + b);
	}
}
