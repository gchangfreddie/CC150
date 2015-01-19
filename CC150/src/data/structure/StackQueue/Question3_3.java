package data.structure.StackQueue;

import java.util.LinkedList;
import java.util.Stack;

public class Question3_3 {
	LinkedList <Stack<String>> set = new LinkedList<Stack<String>>(); 
	int capacity; 
	
	public Question3_3(int c) {
		capacity = c; 
	}
	
	public void push(String s){
		Stack<String> stack ; 
		if (set.isEmpty() || set.peekLast().size() == capacity)  {
			stack = new Stack<String>(); 
			set.addLast(stack); 
		} else{
			stack =  set.peekLast(); 
		}
		stack.push(s); 
	}
	
	public String pop() {
		if (set.isEmpty()) return null; 
		Stack<String> stack = set.peekLast(); 
		String result = stack.pop(); 
		if (stack.isEmpty()) {
			set.removeLast(); 
		}
		return result; 
	}
	
	public String peek() {
		if (set.isEmpty()) return null; 
		Stack<String> stack = set.getLast(); 
		return stack.peek(); 
	}
	
	public String popAt(int index) {
		if (set.isEmpty()) return null; 
		Stack<String> stack = set.get(index); 
		if (stack.isEmpty()) return null;
		String result = stack.pop();
		if (index< (set.size() -1) && !stack.isEmpty()) {
			move(index); 
		}
		if (stack.isEmpty()) set.remove(index); 
		return result;
	}
	
	private void move(int index) {
		Stack<String> stack = shift(index); 
		if (index == set.size() -2) {
			if (stack.isEmpty()) set.remove(index+1); 
		} else {
			move(index+1); 
		}
	}

	private Stack<String> shift(int index) {
		Stack<String> stack = set.get(index + 1); 
		set.get(index).push(stack.firstElement()); 
		shiftBottom(stack);
		return stack;
	}
	
	private void shiftBottom(Stack<String> stack) {
		for (int i=0; i<stack.size()-1; i++) {
			stack.set(i, stack.get(i+1)); 
		}
		stack.pop(); 
	}
	
	
	public static void main(String[] args) {
		Question3_3 q = new Question3_3(2); 
		q.push("b"); 
		q.push("d"); 
		q.push("e"); q.push("a"); q.push("ab"); q.push("ed"); q.push("g"); q.push("l"); 
		q.push("t"); q.push("y"); q.push("we");  
		
		System.out.println(q.popAt(2)); 
		
		while(!q.set.isEmpty()) {
			System.out.print(q.pop() + "  ");
		}
		
	}
}
