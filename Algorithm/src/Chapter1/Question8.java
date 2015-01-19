package Chapter1;

public class Question8 {

	public static void main(String[] arg){
		String s = "waterbottle"; 
		String s1 =  "waterbottle"; 
		
		if ((s1+s1).indexOf(s)>=0) System.out.println(true);
		else System.out.println(false);
		
		System.exit(0);
	}
}
