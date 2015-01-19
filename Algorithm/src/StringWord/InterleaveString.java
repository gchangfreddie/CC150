package StringWord;

public class InterleaveString {
	public boolean isInterleave(String s1, String s2, String s3) {
        return foo(s1, 0, s2, 0, s3, 0); 
    }
    
    public boolean foo(String s1, int i, String s2, int j, String s3, int k) {
    	if(k==s3.length()){ 
    		if( i==s1.length() && j==s2.length()) return true; 
    		return false;
    	}
        char c = s3.charAt(k); 
        if (i<s1.length() && s1.charAt(i)==c) {
            if (foo(s1, i+1, s2, j, s3, k+1)) return true;
        }
        if (j<s2.length() && s2.charAt(j)==c) {
            if (foo(s1, i, s2, j+1, s3, k+1)) return true; 
        }
        return false; 
    }
    
    public static void main(String[] args){
    	InterleaveString is = new InterleaveString(); 
    	System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbbaccc")); 
    	System.out.println(is.isInterleave("a", "b", "c"));
    }
}
