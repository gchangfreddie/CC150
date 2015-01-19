package data.structure.StackQueue;

import java.util.Stack;

public class Question3_6 {
	
	Stack<Integer> s1 = new Stack<Integer>(), s2 = new Stack<Integer>();
	
	public void sort() {
		if (s1.isEmpty()) return; 
		
		while (!s1.isEmpty()) {
			int item = s1.pop();
			while (!s2.isEmpty() && s2.peek()> item) {
				s1.push(s2.pop()); 
			}
			s2.push(item); 
		}
	}
	
	public static void main(String[] args){
		Question3_6 q = new Question3_6(); 
		
		q.s1.push(16); q.s1.push(4); q.s1.push(9); q.s1.push(12); q.s1.push(7); q.s1.push(5); 
		
		q.sort(); 
		
		while(!q.s2.isEmpty()) {
			System.out.print("  " + q.s2.pop());
		}
		
	}

}
