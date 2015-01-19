package permutation;

import java.util.*;

public class PermutationSquence {
	public String getPermutation(int n, int k) {
		int[] num = new int[n+1]; 
		for (int i=1; i<n+1; i++) {
			num[i]=i;
		}
		StringBuilder sb =new StringBuilder(); 
		k--; 
		for (int i=n-1; i>=0; i--) {
			int m = k/factorial(i)+1; 
			sb.append(num[m]+""); 
			for (int j=m; j<n; j++){
				num[j]=num[j+1]; 
			}
			k=k%factorial(i); 
		}
		return sb.toString(); 
	}

	public int factorial(int n) {
		if (n==0 || n==1) return 1; 
		return n*factorial(n-1); 
	}
	
	public String getPermutation1(int n, int k) {
        List<String> res = new ArrayList<String> (); 
        boolean visited[] = new boolean[n+1]; 
        getPer(res, visited, n, "", k, 0); 
        return res.get(k-1); 
    }
    
    public int getPer(List<String> res, boolean[] visited, int n, String s, int k, int index) {
        if (s.length()==n) {
            res.add(s);
            return index+1;
        }    
        for (int i=1; i<=n; i++) {
            if (!visited[i]){
                visited[i]=true; 
                index = getPer(res, visited, n, s+String.valueOf(i), k, index); 
                if (index>k) return index;
                visited[i]=false; 
            }  
        }
        return index;
    }

	public static void main(String[] aregs){
		PermutationSquence ps = new PermutationSquence(); 
		System.out.println(ps.getPermutation1(4, 6)); 
	}
}
