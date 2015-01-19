package data.structure.StackQueue;

public class Question3_1_FixSize {
	String[] array = new String[9];  
	int stackLen = array.length/3;
	int[] stackPointer = new int[]{0, stackLen, stackLen * 2}; 
	int[] stackSize = new int[]{0, 0, 0};
	
	public void push(int stackNum, String item) {
		if (stackSize[stackNum]>=stackLen){
			System.out.println("stack " + stackNum + " is full");
			return; 
		}
		array[stackPointer[stackNum]++] = item; 
		stackSize[stackNum]++; 
	}
	
	public String pop(int stackNum) {
		String result = null; 
		if (stackSize[stackNum] <= 0) {
			System.out.println("stack " + stackNum + " is empty");
		} else {
			result = array[--stackPointer[stackNum]]; 
			array[stackPointer[stackNum]] = null;
			stackSize[stackNum]--; 
		}
		
		return result; 
	}
	
	public String peek(int stackNum){
		String result = null;
		if (stackSize[stackNum] <= 0) {
			System.out.println("stack " + stackNum + " is empty");
		} else {
			result = array[stackPointer[stackNum]]; 
		}
		
		return result; 
	}
	
	public static void main(String[] args) {
		Question3_1_FixSize q = new Question3_1_FixSize(); 
		
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
