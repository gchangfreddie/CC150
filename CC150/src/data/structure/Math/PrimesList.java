package data.structure.Math;

import java.util.LinkedList;

public class PrimesList {
	
	LinkedList<Boolean> primeList ;
	
	public void buildList(int n) {
		primeList = new LinkedList<Boolean>();
		
		primeList.add(0, true); 
		primeList.add(1, true); 
		
		for (int i=2; i<=n; i++) primeList.add(i, true); 
		
		int prime = 2; 
		while (prime<=Math.sqrt(n)){ // if prime > math.sqrt(n), that means we have checked the other smaller factor 
			getCutoff(prime, n); 
			prime = findNextPrime(prime, n); 
		}
		
		for (int i=0; i<=n; i++) {
			if (primeList.get(i)) 
				System.out.print(i + " ");
		}
	}
	
	private void getCutoff(int p, int n) {
		
		for (int i=p*p; i<= n; i=i+p) {
			primeList.set(i, false); 
		}
		
	}
	
	private int findNextPrime(int p, int n) {
		for (int i=p+1; i<n+1; i++) {
			if (primeList.get(i)) return i; 
		}
		return n+1; 
	}
	
	public static void main (String[] args) {
		PrimesList pl = new PrimesList(); 
		
		pl.buildList(53); 
	}
	
}
