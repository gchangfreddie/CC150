package Chapter1;

public class StringBuff {
	char[] c; 
	int length; 
	int cap; 
	
	public StringBuff() {
		this(16); 
	}
	
	public StringBuff(int l) {
		cap = l; 
		length =0; 
		c = new char[l] ; 
	}
	
	public StringBuff append(String s) {
		if (s.length() + length > cap) {
			int len = Math.max(cap*2, s.length() + length); 
			char[] nec = new char[len]; 
			for (int i = 0 ;i<length; i++) {
				nec[i] = c[i]; 
			}
			c=nec;
			cap = len; 
		}
		for (int i=0; i<s.length(); i++) {
			c[length+i] = s.charAt(i);
		}
		length +=s.length(); 
		return this; 
	}
	
	public String toString() {
		return new String(c, 0, length); 
	}
	
}
