package data.structure.moderate;

public class SwapNum {
	public void solution(int[] a) {
//		a[0]^=a[1]; 
//		a[1]^=a[0]; 
//		a[0]^=a[1]; 
	
		a[1] = a[1]-a[0];
		a[0]=a[0]+a[1]; 
		a[1]= a[0]-a[1]; 
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{12,5}; 
		SwapNum sn =new SwapNum(); 
		sn.solution(a); 
		for (int i=0; i<2; i++) {
			System.out.println(a[i]);
		}
	}
}
