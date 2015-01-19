package data.structure.Bit;

public class Quetion5_5 {

	public static void main(String[] args){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int count = 0; 
		
		for (int c =a^b; c!=0; c= c>>1) {
			if ((c&1)!=0) count++; 
		}
		
		System.out.println("method 1 " +count);
		count=0; 
		for (int c=a^b; c!=0; c=c&(c-1)){
			count++; 
		}
		System.out.println("method 2 " + count);
	}
}
