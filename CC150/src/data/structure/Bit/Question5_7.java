package data.structure.Bit;

public class Question5_7 {
	public static void main(String[] args) {
		int[] a = new int[]{0,1,2,3,4,5,6,7,8,9,14,11,12,13,15}; 
		int result = 0; 
		for (int i=0; i<a.length; i++) {
			result = result ^ a[i]; 
		}
		
		System.out.println(result);
	}
}
