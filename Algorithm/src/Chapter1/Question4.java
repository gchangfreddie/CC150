package Chapter1;

public class Question4 {

	public static void main(String[] args) {
		String s = new String("Grace will get a new better job soon"); 
		StringBuffer sb = new StringBuffer(); 
		
		int count = 0; 
		for (int i =0; i<s.length(); i++) {
			if (s.charAt(i)==' ') {
				count++;
				sb.append("%20"); 
			} else {
				sb.append(s.charAt(i)); 
			}
			
		}
		System.out.println(sb.toString());
		char[] c = new char[s.length() + count*2]; 
		int j = c.length -1 ;
		for (int i=s.length()-1; i>=0; i--) {
			if (s.charAt(i) == ' ')  {
				c[j--] = '0'; c[j--] = '2'; c[j--] = '%'; 
			} else {
				c[j--] = s.charAt(i); 
			}
		}
		
		System.out.println(new String(c));
	}
}
