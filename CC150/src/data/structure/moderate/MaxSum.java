package data.structure.moderate;

public class MaxSum {
	public static int findMax(int a, int b) {
		int signA = sign(a); 
		int signB = sign(b); 
		int signC = sign(a-b);
		
		int s = signA ^ signB; //s==1 is a, b different sign; 
		int k = signA * s + signC * flip(s); 
		int q = flip(k); 	
		return a*k+b*q; 	
	}
	
	public static int sign(int a) {
		return flip((a>>31) & 0x1); 
	}
	
	public static int flip(int a) {
		return a^1; 
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(findMax(3, -5));
	}
}
