package data.structure.Bit;

public class Question5_4 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); 
		if ((n&(n-1)) == 0) {
			System.out.println(n + " is pow of 2");
		}
		else {
			System.out.println(n + " is NOT pow of 2");
		}
	}
}
