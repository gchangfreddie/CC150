package sort;

public class BUMergeSort {
	public static void main(String[] args){
		String[] array = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl",
				"mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos",
				"down","path","onyx","mows"};
		Comparable[] aux = new Comparable[array.length];  
		for (int sz=1; sz<array.length; sz*=2){
			for (int i=0; i<array.length-sz-1; i+=sz*2){
				mergeSort(array, aux, i, i+sz-1, Math.min(array.length-1, i+sz+sz-1)); 
			}
		}
		for (int i=0; i<array.length; i++) {
			System.out.print(" "+array[i]);
			if (i%10==0) System.out.println();
		}
	}
	
	public static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int m, int hi){
		if (lo>=hi) return; 
		int i=lo, j=m+1, k=lo;
		while(k<=hi){
			if (i>m) aux[k++] = a[j++]; 
			else if (j>hi) aux[k++] = a[i++]; 
			else if (a[i].compareTo(a[j])<0) aux[k++]=a[i++]; 
			else aux[k++]=a[j++]; 
		}
		for (int f=lo; f<=hi; f++){
			a[f]=aux[f]; 
		}
	}
}
