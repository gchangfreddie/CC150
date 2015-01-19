package data.structure.array;

public class Question1_4 {
	
	public String solution(String s) {
		char[] c = s.toCharArray(); 
		StringBuffer sb = new StringBuffer(); 
		for (int i=0; i<c.length; i++) {
			if (c[i] != ' ') sb.append(c[i]); 
			else {
				sb.append("%20"); 
			}
		}
		return sb.toString(); 
	}
	
	public static void main(String[] args) {
		Question1_4 q = new Question1_4(); 
		String s = "Grace will get a new better job soon"; 
		
		System.out.println(q.solution1(s));
	}

	public String solution1(String s){
		char[] c= s.toCharArray(); 
		int len = s.length();
		int space = 0; 
		for (int i=0; i<len; i++) {
			if(c[i]==' ') space++; 
		}
		int newLen = len + space* 2;
		char[] c1 = new char[newLen+1];
		c1[newLen]='\n'; 
		for (int i=len-1; i>=0; i--) {
			if (c[i]==' ') {
				c1[--newLen]='0'; 
				c1[--newLen]='2';
				c1[--newLen]='%'; 
			} else{
				c1[--newLen]=c[i]; 
			}
		}
		return new String(c1); 
	}
}
