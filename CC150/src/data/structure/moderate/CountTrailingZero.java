package data.structure.moderate;

public class CountTrailingZero {

	public static void main(String[] args) {
		int n = 275; 
		int res = count(n);  
		System.out.println(res + " " + countF(n));
	}
	
	public static int count(int n) {
		if (n<0) return -1;
		int count = 0; 
		while (n>1) {
			count+=n/5; 
			n/=5; 
		}
		return count; 
	}
	
	public static int countF(int num) {
		int count=0 ; 
		for (int i=5; num/i>0; i*=5) {
			count+=num/i; 
		}
		return count; 
	}
	
}
