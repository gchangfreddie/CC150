package data.structure.Recursion;

public class Question9_1 {

	public int countStep(int n, int[] map){
		if (n<=0) {
			System.err.println("steps must be greater than 0");
			return 0;
		} 
		if (map[n] != 0) return map[n]; // we cache the value in an array. 
		if (n==1) {
			System.out.println("1 1 or 2");
			map[n] = 1; 
			return map[n]; // must return here
		} 
		if (n==2) {
			System.out.println("1 1 or 2");
			map[n] = 2; 
			return map[n]; 
		}
		if (n==3) {
			System.out.println("1 1 1 or 1 2 or 2 1 or 3");
			map[n] = 4; 
			return map[n]; 
		} else {
			map[n] = countStep(n-1, map) + countStep(n-2, map) + countStep(n-3, map); 
		}
		
		return map[n]; 
	}
	
	public static void main(String[] args) {
		System.out.println(-340 % 60);
		int[] map = new int[5]; 
		System.out.println(new Question9_1().countStep(4, map));
	}
	
}
