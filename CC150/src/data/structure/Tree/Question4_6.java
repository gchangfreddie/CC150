package data.structure.Tree;

public class Question4_6 {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3); 
		node.root = null;  
		TreeNode left = new TreeNode(1);
		TreeNode rightRoot = new TreeNode(5); 
		TreeNode rightRoot1 = new TreeNode(4); 
		TreeNode rightRoot2 = new TreeNode(6); 
		TreeNode leaf = new TreeNode(2); 
		
		node.left = left; left.root = node; 
		left.right = leaf;  leaf.root = left; 
		node.right = rightRoot;  rightRoot.root = node;
		node.right.left = rightRoot1;  rightRoot1.root = rightRoot; 
		node.right.right = rightRoot2;  rightRoot2.root = rightRoot; 
		
		TreeNode result = findNextOne(rightRoot2); 
		
		System.out.println(result);
	}
	
	public static TreeNode findNextOne(TreeNode n) {
		// check right subtree to find the leftmost node
		if (n.right != null) {
				return findLeftMost(n.right) ; 
		}
		while(n.root!= null &&n.root.right == n){
			n = n.root; 
		}
		return n.root;
		
	}
	
	public  static TreeNode findLeftMost(TreeNode n) {
		if (n.left == null) return n; 
		return findLeftMost(n.left); 
 	}
	
}
