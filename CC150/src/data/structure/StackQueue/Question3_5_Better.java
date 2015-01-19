package data.structure.StackQueue;

import java.util.Stack;

public class Question3_5_Better {
	Stack<String> oldest = new Stack<String>(), newest = new Stack<String>(); 
	
	public void enqueue(String s) {
		newest.push(s); 
	}
	
	public String dequeue() {
		if(oldest.isEmpty()) {
//			if (newest.isEmpty()) {
//				return "nothing returned"; 
//			}
			while (!newest.isEmpty()) {
				oldest.push(newest.pop()); 
			}
		}
		return oldest.pop(); 
	}
	
	public boolean isEmpty() {
		return oldest.isEmpty() && newest.isEmpty(); 
	}
	
	public static void main(String[] args) {
		Question3_5_Better q = new Question3_5_Better(); 
		
		q.enqueue("Grace");
		q.dequeue(); 
		q.dequeue(); 
		q.enqueue("Zillows"); q.enqueue("redfin");  q.enqueue("facebook"); q.enqueue("Google"); q.enqueue("MicroSoft");
		q.enqueue("facebook"); q.enqueue("Amazon");
		
		while(!q.isEmpty()) {
			System.out.print("  " + q.dequeue());
		}
	}
	
}
