package data.structure.Memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Question10_3_followUP  {
	public static void main(String[] args) {
		int bitsize = 8; 
		int blockNum = 2; 
		byte[] bitfield = new byte[bitsize/8]; 
		int[] block = new int[blockNum]; 

		int  starting = -1; 
		try {
			Scanner in = new Scanner(new FileReader("c:\\log.txt"));
			while (in.hasNextInt()) {
				int n = in.nextInt(); 
				block[n/(bitfield.length *8)] ++; 
			}
			
			for (int i=0; i<block.length; i++) {
				if (block[i] <bitfield.length * 8) {
					starting = i * bitfield.length *8; 
					break; 
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
