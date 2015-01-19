package Chapter1;

import java.util.*;

public class Question2 {
	public static void main(String[] args) {
		String s = "abcdefgh" ; 
		int l = s.length(); 
		char[] sb = new char[l]; 
		for (int i=0; i<l/2+1; i++) { // must be l/2+1 for odd number length
			char c = s.charAt(i); 
			sb[i] = s.charAt(l-1-i); 
			sb[l-1-i] = c; 
		}
		System.out.println(new String(sb));
		System.exit(0);
	}
}
