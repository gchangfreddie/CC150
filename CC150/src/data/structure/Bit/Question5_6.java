package data.structure.Bit;

public class Question5_6 {

	public static void main(String[] args) {
		int n =30; 
		int oddMask = 0xaaaaaaaa, evenMask= 0x55555555; 
		int odd = (n & oddMask) >> 1, even = (n&evenMask) <<1; 
		System.out.println(odd|even);
	}
}
