package data.structure.Recursion;

import java.util.*;

public class Question9_10 {

	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int maxHeight = 0; 
		ArrayList<Box> max_stack = null; 
		for (int i=0; i<boxes.length; i++) {
			if (boxes[i].canBeTop(bottom)) {
				ArrayList<Box> newStack = createStackR(boxes, boxes[i]); 
				int newHeight = getHeight(newStack); 
				if (newHeight > maxHeight) {
					maxHeight = newHeight; 
					max_stack = newStack; 
				}
			}
		}
		if (max_stack==null) max_stack = new ArrayList<Box>(); 
		if (bottom!=null) {
			max_stack.add(0, bottom); 
		}
		return max_stack; 
	}
	
	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stackMap) {
		if (bottom != null && stackMap.containsKey(bottom)) {
			return stackMap.get(bottom); 
		}
		int maxHeight = 0; 
		ArrayList<Box> max_stack = null; 
		for (int i=0; i<boxes.length; i++) {
			if (boxes[i].canBeTop(bottom)) {
				ArrayList<Box> newStack = createStackR(boxes, boxes[i], stackMap); 
				int newHeight = getHeight(newStack); 
				if (newHeight > maxHeight) {
					maxHeight = newHeight; 
					max_stack = newStack; 
				}
			}
		}
		if (max_stack==null) max_stack = new ArrayList<Box>(); 
		if (bottom!=null) {
			max_stack.add(0, bottom); 
		}
		stackMap.put(bottom, max_stack); 
		return (ArrayList<Box>)max_stack.clone(); 
	}
	
	public static int getHeight(ArrayList<Box> boxes) {
		int height = 0; 
		for (Box box : boxes) {
			height+=box.getHeight();  
		}
		return height; 
	}
	
	public static void main(String[] args) {
		Box[] boxes = new Box[] {
				new Box(3,5,8), new Box(4,9,10), new Box(1,1,2), new Box(5,12,12), new Box (10, 13, 15)
		}; 
		ArrayList<Box> max= null; 
		HashMap<Box, ArrayList<Box>> map = new HashMap<Box, ArrayList<Box>>(); 
		int maxH = 0; 
		for (int i=0; i<boxes.length; i++) {
			ArrayList<Box> newS = createStackR(boxes, boxes[i], map); 
			if (getHeight(newS)> maxH) { 
				maxH = getHeight(newS); 
				max = newS; 
			}
		}
		for(Box box :max) {
			System.out.print(box.getHeight()+ " ");
		}
		System.out.println(maxH);
	}
}

class Box implements Comparable<Object>{
	private int height, width, depth; 

	Box(int h, int w, int d) {
		height = h; 
		width = w; 
		depth = d; 
	}

	int getHeight() {
		return height; 
	}
	
	public int compareTo(Object o) {
		if (o instanceof Box) {
			Box b = (Box) o; 
			if (this.height < b.height && width < b.width && depth < b.depth) return -1 ; 
			else return 1;
		}
		return 1; 
	}

	public boolean canBeTop(Box o) { // this can be put in top of o
		if (this.compareTo(o) == -1) {
			return  true;
		}
		return false; 
	}
}