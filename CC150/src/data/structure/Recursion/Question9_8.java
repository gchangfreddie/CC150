package data.structure.Recursion;

public class Question9_8 {
	
	public static int makeChanges(int n, int coin) {
		int nextCoin = 0; 
		
		switch (coin) {
			case 25: 
				nextCoin = 10; 
				break; 
			case 10: 
				nextCoin = 5; 
				break; 
			case 5: 
				nextCoin =1; 
				break;
			case 1: 
				return 1; 
		}
		int ways = 0; 
		for (int i=0; i*coin <=n; i++) {
			ways += makeChanges(n-i*coin, nextCoin); 
		}
		return ways; 
		
	}
	public static void main(String[] args){
		System.out.println(makeChanges(25, 25));
	}
}
