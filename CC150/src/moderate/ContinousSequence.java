package moderate;

public class ContinousSequence {
	public int[] findMaxSubSequence(int[] a){
		int max = Integer.MIN_VALUE; 
		if (a==null || a.length ==0) return null;
		int start = 0, run = start; 
		int[] res = new int[2]; 
		while(run<a.length){
			int temp = a[run]; 
			if (temp>max)  {
				max = temp; 
				res[0]=start; res[1]=run; 
			}
			while (run<a.length-1 && temp>0) {
				run++; temp+=a[run]; 
				if (max<temp) {
					max =temp ; 
					res[0]=start; res[1]=run; 
				}	
			}
			start = run+1; run = start;  
		}
		return res; 
	}
	
	public static void main(String[] args) {
		ContinousSequence cs = new ContinousSequence(); 
		int[] a = new int[]{2,-8,3,-2,4,-10};
		int[] res = cs.findMaxSubSequence(a); 
		int max = 0; 
		for (int i=res[0]; i<=res[1]; i++) {
			System.out.print(" " + a[i]);
			max+=a[i]; 
		}
		System.out.println(" sum is " + max );
		System.exit(0);
	}
}
