package data.structure.Bit;

public class Question5_1 {

	public static void main(String[] args) {
		System.out.println(updateBits(0x400, 0x13, 2, 6));
	}
	
	public static int updateBit(int n, int m, int i, int j) {
		int mask = (~(1<<(j+1)-1)) | ((1<<i)-1); 
		
		return (m<<i) | (n & mask); 
	}
	
	public static long updateBits(int n, int m, int i, int j) {
		int allOnes = ~0; 
		
		int left = allOnes << (j+1); 
		int right = ((1<<i)-1); 
		int mask = left | right; 
		
		int n_clear = n&mask; 
		int m_shifted = m << i; 
		return n_clear | m_shifted; 
	}
}
