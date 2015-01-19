package data.structure.Recursion;

public class Question9_3 {

	
	public static boolean findMagic(int[] sortedA) {
		if (sortedA.length==0 || sortedA[0] >0) return false;
		if (sortedA[0] == 0 ) {
			System.out.println(" 0 is the magic index"); 
			return true;
		}
//		return findMagicIndex(sortedA, 0, sortedA.length-1); 
		return findMIFollowiUp(sortedA, 0, sortedA.length-1); 
	}
	
	private static boolean findMagicIndex(int[] a, int start, int end){
		if (end<start) return false;
		int mid = start+(end-start) /2; 
		if (a[mid] == mid) {
			System.out.println(mid);
			return true; 
		}
		if (a[mid] < mid) return findMagicIndex(a, mid+1, end); 
		else return findMagicIndex(a, start, mid-1); 
	}
	
	public static void main(String args[] ){
	
		int[] a = new int[]{-10,-5,4,5,5,6,6,7,7,9,12,13}; 
		findMagic(a); 
		
	}
	
	private static boolean findMIFollowiUp(int[] a, int start, int end){
		if (end<start) return false;
		int mid = start+(end-start) /2; 
		if (a[mid] == mid) {
			System.out.println(mid);
			return true; 
		}
		/**
		 * we don't need check whether a[mid]><mid, this is very tricky
		 */
		return findMIFollowiUp(a, start, Math.min(a[mid], mid-1))||
			findMIFollowiUp(a, Math.max(a[mid],mid+1), end); 
		
	}
}
