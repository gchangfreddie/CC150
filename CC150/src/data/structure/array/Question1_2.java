package data.structure.array;

public class Question1_2 {
	public String solution(String s) {
		int start=0, end=s.length()-1;
		char[] c = new char[s.length()]; 
		while (start<end) {
			c[end] = s.charAt(start);
			c[start++] = s.charAt(end--); 
		}
		return new String (c); 
	}
	
	public static void main(String[] args) {
		Question1_2 q = new Question1_2();
		char a='a', b='b'; 
		a= (char)((int)a^(int)b); 
		b= (char)((int)a^(int)b); 
		a= (char)((int)a^(int)b); 
		System.out.println(a + " " + b); // we can use XOR to switch 2 int or char's value
		
		System.out.println(q.solution(new String("noos boj retteb a teg lliw ecarG"))); 
	}
}
