package data.structure.moderate;

public class IntConvertEng {
	public String[] digits = {"One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine"}; 
	public String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	public String[] tens = {"Ten", "Twenty", "Thirty", "Forty",	"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	public String[] bigs = {"", "Thousand", "Million"};
	
	public String convert(int i) {
		if (i==0) return "Zero"; 
		if (i<0) return "Negative" + convert(i*-1); 
		
		int count=0; 
		StringBuffer sb = new StringBuffer(); 
		
		while (i>0) {
			if (i%1000!=0) {
				sb = sb.insert(0, conHun(i%1000) + " "+ bigs[count] + " ") ; 
			}
			count++; 
			i/=1000; 
		}
		return sb.toString(); 	
	}
	
	public String conHun(int i) {
		StringBuffer sb = new StringBuffer(); 
		if (i/100>0){
			sb.append(digits[i/100-1] + " Hundred");
			i%=100; 
		}
		if (i<20 && i>10) {
			sb.append(" "+teens[i-11]);
			return sb.toString(); 
		} 
		if (i>=20 || i==10) {
			sb.append(" " + tens[i/10-1]); 
			i%=10; 
		} 
		if (i>0)
			sb.append(" "+ digits[i-1]); 
		return sb.toString(); 
	}
	
	public static void main(String[] args) {
		IntConvertEng nce = new IntConvertEng(); 
		System.out.println(nce.convert(19010984));
	}
}
