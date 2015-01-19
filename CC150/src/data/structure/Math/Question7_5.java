package data.structure.Math;

import java.awt.Point;

public class Question7_5 {

}

class Square {
	private int left, right, top, bottom;
	
	// find the middle of square
	public Point middle() {
		return new Point((this.left+this.right)/2, (this.top + this.bottom)/2); 
	}
	
//	public Point extend(Point mid1, Point mid2, double size) {
//		double xdir = mid1.x < mid2.x ? -1 : 1; 
//		double ydir = mid2.y < mid2.y ? -1 : 1; 
//	}
}
