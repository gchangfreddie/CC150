package data.structure.Tree;

public class Question4_5 {
	public static void main(String[] args) {
	
		TreeNode node = new TreeNode(3); 
		TreeNode left = new TreeNode(1);
		TreeNode rightRoot = new TreeNode(5); 
		TreeNode rightRoot1 = new TreeNode(4); 
		TreeNode rightRoot2 = new TreeNode(6); 
		TreeNode leaf = new TreeNode(2); 
		
		node.left = left; 
		node.right = rightRoot; 
		node.right.left = rightRoot1; 
		node.right.right = rightRoot2; 
//		node.right.right.left = leaf;
		
		System.out.println(node.isBST(0)); 
		System.out.println(node.isBSTree(node, 0, 100));
		
		node.convertToList(node); 
		for (TreeNode item: node.a) {
			System.out.print(" " + item);
		}
	
	}
	
	public static int last_printed = 0; 
	public static boolean checkBST(TreeNode n) {
		if (n==null) return true; 
		if (!checkBST(n.left)) return false; 
		if (n.name <=last_printed) return false; 
		last_printed = n.name; 
		
		if (!checkBST(n.right)) return false; 
		
		return true; 
	}
	
}
