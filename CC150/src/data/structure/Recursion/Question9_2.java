package data.structure.Recursion;

import java.awt.Point;
import java.util.*;

public class Question9_2 {
	private static Set<Point> offLimits = new HashSet<Point>(); 
	private static Hashtable<Point, Integer> cache = new Hashtable<Point, Integer>(); 
	private static Hashtable<Point, Boolean> cache1 = new Hashtable<Point, Boolean>(); 
	
	public static int countStep(int x, int y, Point originalPoint) {
		if (originalPoint.x == x && originalPoint.y == y) {
			return 0; 
		} 
		Point p = new Point(x, y); 
		if (cache.contains(p)) {
			return cache.get(p); 
		}
		if (originalPoint.x == x || originalPoint.y == y) {
			cache.put(p, 1); 
			return 1; 
		} 
		int res1 = countStep(x-1, y, originalPoint), res2 = countStep(x, y+1, originalPoint); 
		cache.put(p, res1 + res2); 
		return res1 + res2;  
	}
	
	public static boolean findPath(int x, int y, Point originalPoint, ArrayList<Point> path) {
		Point p = new Point(x, y); 
		if (cache1.contains(p)) {
			return cache1.get(p); 
		}
		if (originalPoint.x == x && originalPoint.y == y) {
			return true; 
		} 
		if (followUp(p)) return false; 
		boolean suc = false; 
		if (x>=1 ){
			suc = findPath(x-1, y, originalPoint, path); 
		}
		if (!suc && y<=-1 ){
			suc = findPath(x, y+1, originalPoint, path); 
		}
		cache1.put(p, suc);
		if (suc) path.add(p); 
		return suc;
	}
	
	public static void main(String[] args){
		offLimits.add(new Point(0,-1)); 
		offLimits.add(new Point(2,-5)); 
		System.out.println(countStep(5,-5, new Point(0,0)));
		ArrayList<Point> pathList = new ArrayList<Point>(); 
		findPath(5,-5, new Point(0,0), pathList); 
		for (int i=0; i<pathList.size(); i++) {
			System.out.print(" (" +pathList.get(i).x +","+ pathList.get(i).y + ")");
		}
	}
	
	private static boolean followUp(Point a) {
		if (offLimits.contains(a)) return true; 
		return false; 
	}
}
