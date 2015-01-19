package CC150;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Question7_6 {

	public static void main(String[] args) {
		Point[] points = new Point[10]; 
		
		for (int i=0; i<points.length; i++) {
			// add point to array
		}
		
		Hashtable<Double, List<Line>> ht = new Hashtable<Double, List<Line>>(); 
		int max = 0; 
		List maxLines = null;
		for (int i=0; i<points.length; i++) {
			for (int j=i+1; j<points.length; j++){
				// render line of points[i] and points[j], 
				Line l = new Line(points[i], points[j]); 
				List lines = null; 
				// put the line in the hashtable
				if (ht.containsKey(l.slope)) lines = ht.get(l.slope); 
				else {
					lines = new ArrayList<Line>(); 
					ht.put(l.slope, lines); 
				}
				lines.add(l); 
				// check the paper for this part
				if (lines.size() > max) {
					max = lines.size(); 
					maxLines = lines; 
				}
				
 			}
			
	}
}
}

class Line implements Comparable<Line>{
	double yInsection; 
	double slope;
	boolean infinite_slope = false; // when line is upright to x axis, true
	
	public int compareTo(Line o) {
		if (o.slope == slope && yInsection == yInsection)
		return 0;
		else return -1; 
	} 
	
	public Line(Point x, Point y) {
		slope = (x.x - y.x)/(x.y - y.y); 
		yInsection = x.y - slope*x.x;  
	}
	
}
