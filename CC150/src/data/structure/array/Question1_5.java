package data.structure.array;

import java.util.StringTokenizer;

public class Question1_5 {
	public String solution(String s) {
		System.out.println(countCompression(s));
		int start=0, end=1, len=s.length(); 
		char temp = s.charAt(start); 
		StringBuffer sb = new StringBuffer(); 
		sb.append(s.charAt(start)); 
		for(int i=1; i<len; i++) {
			if (temp!=s.charAt(i)) {
				sb.append(end-start); 
				start=end;  
				temp=s.charAt(start); 
				sb.append(temp); 
			}
			end++; 
		}
		sb.append(end-start); 
		if(sb.length()>= len) return s; 
		else return sb.toString(); 
	}
	
	private int countCompression(String str) {
		if (str==null || str.length()==0) return 0; 
		int count=0, start=0, len=0; 
		for (int i=0; i<str.length(); i++ ) {
			if (str.charAt(start) == str.charAt(i)) {
				count++; 
			} else {
				len+= String.valueOf(count).length()+1; 
				start=i; count=1; 
			}
		}
		len+=String.valueOf(count).length() +1; 
		return len; 
	}
	
	public String solution1(String s){
		int newLen = countCompression(s); 
		if (newLen >= s.length()) return s; 
		
		char[] ca = new char[newLen]; 
		int start=0, end=1, index=0;
		for (int i=1; i<s.length(); i++) {
			if (s.charAt(start) != s.charAt(i)) {
				index = setChar(s, ca, start, end, index);
				start=end; 
			}
			end++; 
		}
		index = setChar(s, ca, start, end, index);
		return new String (ca); 
	}

	private int setChar(String s, char[] ca, int start, int end, int index) {
		ca[index++] = s.charAt(start);
		String temp = String.valueOf(end-start);
		for (int j=0; j<temp.length(); j++) {
			ca[index++] = temp.charAt(j); 
		}
		return index;
	}
	
	
	public static void main(String[] args) {
		Question1_5 q = new Question1_5(); 
		String s="bca"; 
		
		System.out.println(q.solution1(s));
	}
}
