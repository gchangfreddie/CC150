package data.structure.Memory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.BitSet;
import java.util.Scanner;

public class Question10_4 {

	public static void main(String[] args) {
		BitSet1 bs = new BitSet1(32); 
		int[] array = new int[16];
		Scanner s;
		try {
			int i =0; 
			s = new Scanner(new FileReader("c:\\log.txt"));
			while(s.hasNextInt()) {
				array[i++] = s.nextInt(); 
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		for (int i=0; i<array.length; i++) {
			if (bs.get(array[i])) {
				System.out.println(array[i]);
			} else {
				bs.set(array[i]); 
			}
		}
	}
	
	
}

class BitSet1 {
	int[] array; 
	
	public BitSet1(int size) {
		array = new int[size>>32]; 
	}
	
	public boolean get(int n) {
		int i = n/32; 
		int j = n%32; 
		if ((array[i]&(1<<j)) !=0) {
			return true; 
		}
		return false; 
	}
	
	public void set(int n) {
		int i = n/32; 
		int j = n%32; 
		array[i] |= 1<<j; 
	}
}
