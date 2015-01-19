package data.structure.StackQueue;

public class Question3_1_FlexSize {
	String[] array = new String[9]; 
	int sLen = array.length/3; 
	StackData[] stacks = new StackData[] {
			new StackData(0, sLen, -1, 0), 
			new StackData(0, sLen, sLen-1, sLen),
			new StackData(0, sLen, sLen*2-1, sLen*2)
	}; 
	
	public void push(int stackNum, String value) {
		if ((stacks[0].size + stacks[1].size + stacks[2].size)>=array.length) {
			System.out.println("Stacks are all full");
			return; 
		}
		StackData stack = stacks[stackNum]; 
		if (stack.size >= stack.capability) {
			// Todo shift next stack (stackNum+1)%3
			expand(stackNum); 
			stack.capability++; 
		}
		
		// Add value to stackNum
		stack.size++; 
		stack.topPointer =getNextIndex(stack.topPointer); 
		array[stack.topPointer]= value;
		
	}
	
	private void expand(int stackNum) {
		shift((stackNum+1)%3); 
	}
	
	private void shift(int stackNum) {
		StackData stack = stacks[stackNum]; 
		if (stack.size >= stack.capability) {
			shift ((stackNum+1) %3); 
			stack.capability++; 
		}
		for (int i=stack.topPointer; isInStack(i, stack.start, stack.topPointer); i= getPrevIndex(i)) {
			array[getNextIndex(i)] = array[i]; 
		}
		stack.capability--;
		stack.start = getNextIndex(stack.start); 
		stack.topPointer = getNextIndex(stack.topPointer); 
	}
	
	private boolean isInStack(int i, int start, int top) {
		if (start<=top && i>=start && i<=top) return true; 
		if (start>=top && i>=start && i<=(top+array.length)) return true; 
		return false; 
	}
	
	private int getNextIndex(int index) {
		if (index == array.length-1) {
			return 0 ; 
		} else {
			return index+1; 
		}
	}
	
	private int getPrevIndex(int index) {
		if (index==0) {
			return array.length-1; 
		} else {
			return index-1;
		}
	}

	public String pop(int stackNum) {
		String result =null;
		
		if (stacks[stackNum].size==0 ) {
			System.out.println("Stack " + stackNum + " is empty");
		} else {
			StackData stack = stacks[stackNum]; 
			stack.size--; 
			result = array[stack.topPointer]; 
			array[stack.topPointer] = null; 
			stack.topPointer = getPrevIndex(stack.topPointer); 
		}
		return result; 
	}
	
	public String peek(int stackNum) {
		String result =null;
		
		if (stacks[stackNum].size==0 ) {
			System.out.println("Stack " + stackNum + " is empty");
		} else {
			StackData stack = stacks[stackNum]; 
			result = array[stack.topPointer]; 
		}
		return result; 
	}
	
	public static void main(String[] args) {
		Question3_1_FlexSize q = new Question3_1_FlexSize(); 
		
		q.push(0, "Grace"); 
		q.push(1, "Cindy"); 
		q.push(2, "Sarah");
		q.push(0, "G"); 
		q.push(2, "S");
		q.push(0, "MSTR"); 
		q.push(0, "Sysmind"); 
		q.push(2, "Google");
		q.push(2, "LinkedIn");
		
		System.out.println(q.pop(0));
		System.out.println(q.pop(0));
		System.out.println(q.pop(1));
		q.push(0, "Sysmind"); 
		System.out.println(q.peek(1));
		
		q.push(0, "Ge"); 
		q.push(1, "Cy"); 
		q.push(2, "Sh"); 
		q.push(2, "out");
	}
	
}

class StackData{
	int size;
	int capability; 
	int topPointer; 
	int start; 
	
	StackData(int s, int c, int t, int start) {
		size = s; 
		capability = c; 
		topPointer = t; 
		this.start = start; 
	}
}