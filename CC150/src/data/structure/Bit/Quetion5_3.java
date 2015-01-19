package data.structure.Bit;

public class Quetion5_3 {
	public static void getNext(int n) {
		int mask=1; 
		int m = n; 
		int index = 0; 
		int start, end;
		
		while(m!=0 && (m & mask) == 0) {
			m=m>>1;
			index++; 
		}
		if (m == 0) return; 
		start = index; 
		
		while (m!=0 && (m&mask) !=0) {
			m=m>>1; 
			index++; 
		}
		end = index; 
		
		mask = 1<<end; 
		n = n| mask; 
		
		mask = (1<<(end-1)-1) >> start; 
		
	}
	
	public static void main(String[] args) {
		int n = 11;
		int a = 1<<7 ;
		int b =a-1; 
		int mask = ~b; 
		n= n&mask; 
	}
	
}
