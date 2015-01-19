package data.structure.SortSearch;

public class Question11_8 {
	public static void main(String[] args) {
		Node root = null; 
		root = track(3, root); 
		track(4, root); 
		track(5, root); track(6, root); track(12, root); track(1, root); track(7, root); 
		System.out.println(getRankOfNumber(8, root));
	}
	
	private static Node track(int x, Node root) {
		if(root== null) {
			return new Node(x); 
		} else {
			if (x<=root.value) {
				root.left = track(x, root.left); 
				root.size++; 
				return root; 
			} else{
				root.right = track(x, root.right); 
				return root; 
			}
		}
	}
	
	private static int getRankOfNumber(int x, Node root) {
		if (root== null) return -1;
		if (root.value==x) return root.size; 
		if (root.value<x ) {
			int temp = getRankOfNumber(x, root.right); 
			if (temp==-1) return -1; 
			return root.size + 1+ temp; 
		} else {
			return getRankOfNumber(x, root.left);
		}
	}
}

class Node{
	int value; 
	Node left, right; 
	int size; 
	
	public Node(int v) {
		this.value = v; 
		size = 0; 
	}
	
//	public int getSize() {
//		if (left!= null) size+=left.size; 
//		if (right!=null) size+=right.size; 
//		return size; 
//	}
}
