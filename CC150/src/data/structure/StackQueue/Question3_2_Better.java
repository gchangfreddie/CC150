package data.structure.StackQueue;

import java.util.Stack;

public class Question3_2_Better {
	
	Stack<Integer> s, smin; 
	
	public Question3_2_Better() {
		s = new Stack<Integer>(); 
		smin = new Stack<Integer>(); 
	}
	
	public void push(int i) {
		s.push(i); 
		if (smin.isEmpty() || i<=smin.peek()) {
			smin.push(i); 
		}
	}
	
	public int pop()	{
		int result = s.pop(); 
		if (result == smin.peek()) smin.pop(); 
		return result; 
	}
	
	public int getMin() {
		return smin.peek(); 
	}
	
	public static void main(String[] args) {
		Question3_2_Better s = new Question3_2_Better();
		s.push(5); 
		s.push(7); 
		s.push(2); 
		s.push(3); 
		s.push(1); 
		
		System.out.println(s.getMin());
		s.pop(); 
		System.out.println(s.getMin());
		s.pop(); 
		System.out.println(s.getMin());
		s.pop(); 
		System.out.println(s.getMin());
		
	}

}
