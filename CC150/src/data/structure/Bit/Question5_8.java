package data.structure.Bit;

public class Question5_8 {
	public static void main(String[] args)	{
		byte[] screen = new byte[256]; 
		int width = 128; 
		
		drawHorizontalLine(screen, width, 8, 55, 2); 
//		drawline(screen, width, 8, 55, 2); 
		for (int i=0; i< screen.length; i++) {
			if (screen[i] !=0) {
				System.out.print("  i is " +i + "  "+ screen[i]  );
				if (i%8==0) System.out.println();
			}
		}
		System.out.println("   "+Math.sqrt(900)); 
	}
	
	public static void drawHorizontalLine(byte[] s, int w, int x1, int x2, int y) {
		int start = w/8 * y + x1/8 , end = w/8 * y + x2/8;
		for (int i = start+1; i<end; i++) {
			s[i] =(byte) 0xFF; 
		}
		
		int mask = 0xFF>>(x1%8);
		int mask1 = ~(0xFF>>((x2%8)+1)); 	
		if (x1/8 == x2/8) {
			s[start] |= mask & mask1; 
		} else {
			s[start] |=mask; 
			s[end] |= mask; 
		}
		
		
	}
	
	public static void drawline(byte[] screen, int width, int x1, int x2, int y) {
		int start_offset = x1 %8, end_offset = x2 % 8; 
		int first_fully_byte = x1/8, last_fully_byte = x2/8; 
		if (start_offset !=0 ) first_fully_byte++; 
		if (end_offset !=7) last_fully_byte--; 
		
		for (int b = first_fully_byte; b<=last_fully_byte; b++) {
			screen[(width/8)*y + b] = (byte) 0xff; 
		}
		
		byte start_mask = (byte) (0xFF >> start_offset); 
		byte end_mask = (byte) ~(0xFF >> (end_offset+1));
		
		if ((x2/8) == (x2/8)) {
			byte mask = (byte) (start_mask & end_mask); 
			screen[(width/8) * y + (x1/8)] |= mask; 
		} else {
			if (start_offset !=0) {
				int byte_number = (width/8) *y + first_fully_byte -1; 
				screen[byte_number] |=start_mask;
			} if (end_offset !=7) {
				int byte_number = (width/8) *y + last_fully_byte +1; 
				screen[byte_number] |=end_mask; 
			}
		}
	}
}
