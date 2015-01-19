package data.structure.Memory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question10_3 {
	public static void main(String[] args) {
		long numberOfInts = ((long)Integer.MAX_VALUE) ; 
		
		byte[] bitFields = new byte[2];
		
		try {
			Scanner in = new Scanner(new FileReader("c:\\log.txt"));
			while (in.hasNextInt()) {
				int n = in.nextInt(); 
				
				bitFields[n/8] |= (byte)(1 << (n%8)); 
				
			}
			
			for (int i=0; i<bitFields.length; i++){
				for (int j=0; j<8; j++) {
					if ((bitFields[i] & (1<<j)) == 0) {
						System.out.println(i*8 + j);
					}
				}
			}
 		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
