package CC150;

public class Question11_8 {
	public static void main(String[] args) {
		Node root = null; 
		root = track(13, root); 
		track(5, root); track(6, root); 
		track(4, root); 
		track(12, root); 
		track(11, root); track(7, root); 
		print(root); 
		System.out.println(getRankOfNumber(12, root));
		System.exit(0);
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
	
	private static void print(Node root) {
		if (root == null) return ;
		print(root.left); 
		System.out.println(root.value + " " + root.size);
		print(root.right); 
	}
	
	private static int getRankOfNumber(int x, Node root) {
		if (root== null) return 0; 
		if (root.value<=x ) {
			int temp = root.size + getRankOfNumber(x, root.right); 
			return temp+1; 
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
		size=0; 
	}
	
}