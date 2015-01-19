package bit;

import java.util.BitSet;

public class SingleNumberII {
	public int singleNumber(int[] a) {
		int res = 0; 
		for (int i=0; i<32; i++){
			int bit=0; 
			for (int j=0; j<a.length; j++){
				bit += (a[j]>>i) &1; 
			}
			bit %= 3; 
			res += bit<<i; 
		}
		return res; 
	}
	
	public static int reverse(int x) {
        boolean neg = false; 
        if (x<0) neg=true; 
        String s = String.valueOf(x); 
        int end = neg ? 1 : 0; 
        StringBuilder sb = new StringBuilder(); 
        for (int i=s.length()-1; i>=end; i--) {
            sb.append(s.charAt(i)); 
        }
        int i=0; 
        while(i>0 && sb.charAt(i)=='0') {
            sb.deleteCharAt(i++); 
        }
        int res = Integer.parseInt(sb.toString()); 
        return neg ? -res : res;
    }
	
	public static void main(String[] args){
		reverse(0); 
	}
}
