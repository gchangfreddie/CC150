package com.find.a.job;

import java.util.ArrayList;

public class PrimeList {

	public static void main(String[] args) {
		int n  = 53; 
		boolean[] a = new boolean[n+1]; 
		a[0] = false; 
		a[1] = false; 
		int i=2; 
		while (i<=Math.sqrt(n)) {
			build(a, i, n);
			i = findNextPrim(a, i, n); 
		}
		
		for (int j=0; j<n+1; j++) {
			if (!a[j]) System.out.print(j + " ");
		}
	}
	
	public static void build(boolean[] list, int v, int n) {
		for (int i=v*v; i<=n; i+=v) {
			list[i] = true;
		}
	}
	
	public static int findNextPrim(boolean[] list, int i, int n) {
		for (int j = i+1; j<n; j++) {
			if (!list[j]) return j; 
		}
		return n; 
	}
}
