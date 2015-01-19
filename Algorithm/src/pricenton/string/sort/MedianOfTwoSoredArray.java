package pricenton.string.sort;

public class MedianOfTwoSoredArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
		int k = A.length+B.length;
        if (k%2==1) {
            return median(A, 0, A.length-1, B, 0, B.length-1, k/2)/1.0; 
        } else {
            return (median(A, 0, A.length-1, B, 0, B.length-1, k/2-1)+ median(A, 0, A.length-1, B, 0, B.length-1, k/2))/2.0; 
        }
    }
    public static int median(int[] a, int sa, int ea, int[] b, int sb, int eb, int k){
    	if (sa>ea) return b[sb+k]; 
        if (sb>eb) return a[sa+k]; 
        if (k==0) return a[sa]<b[sb] ? a[sa] : b[sb]; 
        int lenA = ea-sa+1, lenB = eb-sb+1, len = lenA+lenB; 
        int indexA = sa+lenA*k/len; 
        int indexB = sb+k-lenA*k/len-1;
        if (a[indexA]<b[indexB]) {
        	return median(a, indexA+1, ea, b, sb, indexB, k-(indexA-sa+1)); 
        }       
        else if (a[indexA]>b[indexB]) {
        	return median(a, sa, indexA, b, indexB+1, eb, k-(indexB-sb+1)); 
        }
        else return a[k/2]; 
    }
    
    public static void main(String[] args){
    	int[] a = new int[]{1,3}; 
    	int[] b = new int[]{2,4}; 
    	System.out.println(findMedianSortedArrays(a, b)); 
    }
}
