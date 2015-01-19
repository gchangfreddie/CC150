package data.structure.moderate;

public class Rand7 {
	public static int rand7() {
		while(true) {
			int num = 5*rand5() + rand5(); 
			if (num<21){
				return num%7;
			}
		}
	}
	
	public static int rand5(){
		return (int)(Math.random()*1000%5); 
	}
	
	public static void main(String[] args) {
		for (int i=0; i<14; i++) {
			System.out.println(rand7());
		}
	}
}
