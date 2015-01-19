package data.structure.array;

public class Question1_1 {
	public static void main(String[] args) {
		String a = "graceg"; 
		Question1_1 q = new Question1_1();
		System.out.println(q.solution(a)); 
	}
	
	public boolean solution(String s){
		int checker=0; 
		for (int i=0; i<s.length(); i++) {
			int val = s.charAt(i) - 'a'; 
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1<<val); 
		}
		return true; 
	}
	
	public boolean solution1(String s) {
		if (s.length() > 256) return false; 
		
		boolean[] b = new boolean[256]; 
		for (int i=0; i<s.length(); i++) {
			int val = s.charAt(i); 
			if (b[val]) return false; 
			b[val] = true; 
		}
		return true; 
	}
}
