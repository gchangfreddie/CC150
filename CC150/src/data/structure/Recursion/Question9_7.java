package data.structure.Recursion;

import java.awt.Point;

public class Question9_7 {
	enum Color{red, blue, green, white}; 
	
	public static boolean paintFill(Color[][] screen, Color orgColor, Color paint, int x, int y) {
		
		if (x<0 || x > screen[0].length || y<0 || y>screen.length) {
			return false; 
		}
		if (screen[y][x] == orgColor) {
			screen[y][x] = paint; 
			paintFill(screen, orgColor, paint, x+1, y); 
			paintFill(screen, orgColor, paint, x-1, y); 
			paintFill(screen, orgColor, paint, x, y+1); 
			paintFill(screen, orgColor, paint, x, y-1);
		}
		return true; 
	}
	
	public static boolean paintFill(Color[][] screen, Color paint, int x, int y) {
		Color c = screen[y][x];
		if (c == paint) return false;
		return paintFill(screen, c, paint, x, y); 
	}
}
