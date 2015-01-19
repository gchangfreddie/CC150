package Chapter1;

public class Question5 {
	
	public static void main(String[] args) {
		String s = new String("abcca"); 
		char[] c = s.toCharArray(); 
		
		int count = 1; char pre = c[0];
		StringBuffer sb = new StringBuffer(); 
		sb.append(pre); 
		
		for (int i=1; i<c.length; i++) {
			if (c[i] == pre) count++; 
			else {
				pre = c[i]; 
				sb.append(count); 
				sb.append(pre); 
				count = 1; 
			}
		}
		sb.append(count); 
		
		if(sb.length()>=s.length()) System.out.println(s);
		else System.out.println(sb.toString());
		System.exit(0);
	}
}
