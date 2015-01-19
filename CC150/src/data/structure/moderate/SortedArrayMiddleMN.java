package data.structure.moderate;

public class SortedArrayMiddleMN {
	public void findUnsortedSequence(int[] array){
		//find left end
		int m1 = findLeftEnd(array); 
		
		//find right end
		int n1 = findRightEnd(array); 
		
		int[] maxMin=findMaxMin(array, m1, n1); 
		int max = maxMin[1], min = maxMin[0]; 
		
		int m= shrinkLeft(array, m1, min); 
		int n= shrinkRight(array, n1, max); 
		System.out.println(array[m] + " " + array[n]);
	}
	
	private int shrinkLeft(int[] array, int m, int min) {
		int j=m-1; 
		while(j>=0) {
			if (array[j]<=min) return j+1;
			j--; 
		}
		return 0; 
	}
	
	private int shrinkRight(int[] array, int n, int max) {
		int j=n+1; 
		while(j<=array.length-1) {
			if (array[j]>=max) return j-1;
			j++; 
		}
		return array.length-1;   
	}
	
	private int[] findMaxMin(int[] array, int m, int n) {
		int[] res= new int[2]; 
		res[0]=array[m]; res[1]=array[m];
		for (int i=m+1; i<=n; i++){
			if (array[i]<res[0]) res[0]=array[i]; 
			if (array[i]>res[1]) res[1]=array[i]; 
		}
		return res; 
	}
	
	private int findLeftEnd(int[] array){
		int i=1; 
		for (; i<array.length; i++) {
			if (array[i]<array[i-1]) return i-1; 
		}
		return array.length-1;
	}
	
	private int findRightEnd(int[] array){
		int i=array.length-2; 
		for (; i>=0; i--){
			if (array[i]>array[i+1]) return i+1; 
		}
		return 0; 
	}
	
	public static void main(String[] args) {
		SortedArrayMiddleMN sam = new SortedArrayMiddleMN(); 
		int[] array= new int[]{1,2,4,7,10, 11, 7, 16, 18, 19}; 
//		int[] array = new int[]{0, 3, 5, 4, 2, 6, 12}; 
		sam.findUnsortedSequence(array);
		
	}
}
