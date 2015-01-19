package pricenton.string.sort;

public class MSD {
	public static void msdSort(String[] a) {
		String[] aux = new String[a.length]; 
		msdSort(a, aux, 0, a.length-1, 0); 
	}
	
	private static void msdSort(String[] a, String[] aux, int low, int high, int d) {
		if (low>=high) return; 
		int[] count= new int[28]; 
		for (int i=low; i<=high; i++) {
			count[charAt(a[i],d)-'a'+2]++; 
		}
		for (int i=1; i<count.length;i++) {
			count[i]+=count[i-1]; 
		}
		for (int i=low; i<=high; i++) {
			aux[count[charAt(a[i],d)-'a'+1]++] = a[i]; 
		}
		for (int i=low; i<=high; i++) {
			a[i]=aux[i-low]; 
		}
		for (int i=0; i<count.length-1;i++) {
			msdSort(a, aux, low+count[i], low+count[i+1]-1, d+1); 
		}
	}
	
	private static int charAt(String s, int i){
		if (i<s.length()) return s.charAt(i); 
		else return 'a'-1; 
	}
	
	public static void main(String[] args) {
		String[] a = new String[]{"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "shells", "she", "sells", "are", "surely", "seashells"};
		msdSort(a); 
		for (String str : a) {
			System.out.print(str + "  ");
		}
		System.exit(0);
	}
}
