package data.structure.Bit;

public class Question5_2 {
	public static void main(String[] args) {
		System.out.println(getString(0.943));
		System.out.println(printBinary2(0.943));
	}
	
	public static String getString(double num) { 
		StringBuffer sb = new StringBuffer("0."); 
		double i = -1; 
		double base = Math.pow(2, i) ; 
		
		while (num>0) {
			if (num>=base) {
				sb.append("1"); 
				num = num - base; 
			}
			else sb.append("0"); 
			base = Math.pow(2, --i); 
			if (sb.length() >=32) break; 
		}
		
		return sb.toString();
	}
	
	public static String printBinary2(double num) {
		StringBuilder binary = new StringBuilder(); 
		double frac = 0.5; 
		binary.append("0."); 
		while(num > 0) {
			if (binary.length() >64) {
				return "error"; 
			}
			
			if (num >= frac) {
				binary.append(1); 
				num -= frac;
			} else {
				binary.append(0); 
			}
			frac /=2; 
		}
		return binary.toString(); 
		
	}
}
