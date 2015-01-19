package data.structure.Recursion;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class OutputDate {
	public static void main(String args[]) {
		int count = 0; 
		for (int y = 2001; y <=2015; y++) {
			for (int m = 0; m<=11; m++ ) {
				Calendar c = Calendar.getInstance(); 
				c.set(y, m, 16); 
				System.out.println("Altered year is :" + c.getTime());
				if (c.get(Calendar.DAY_OF_WEEK)==2) {
					System.out.println(m+1 + "/"+ 16 + "/" + y);
					count++; 
				}
			}
		}
		System.out.println(count);
	}
}
