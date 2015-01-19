package CC150;

import java.awt.Point;

public class Question7_5 {

	public static void main(String[] args) {
		Square s1 = new Square(new Point(0,0), new Point(4, -4)); 
		Square s2 = new Square(new Point(2, -1), new Point(4, -5)); 
		double slope = (s1.mid.y-s2.mid.y)/(s1.mid.x-s2.mid.x); 
	}
}

class Square{
	Point lt, rb, mid; 
	
	public Square(Point p1, Point p2) {
		lt = p1; 
		rb = p2; 
		mid.x = (rb.x + lt.x)/2; 
		mid.y = (lt.y + rb.y)/2; 
	}
}
