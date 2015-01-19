package data.structure.Tree;

public class Question4_7 {

	public static TreeNode findCA(TreeNode root, TreeNode m, TreeNode n) {
		if (root == m || root == n) return root;
		int ms = isWhichSide(root,m), ns = isWhichSide(root,n); 
		if(ms != ns) {
			return root; 
		}
		
		TreeNode next = (ms ==2 ? root.left : root.right); 
		return findCA(next, m, n); 
	}
	
	public static int isWhichSide(TreeNode root, TreeNode node) {
		if (root == null) return -1; 
		if (root.name < node.name) return 1;
		else return 2; 
	}
	
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
		node.right.left.right = leaf;
		
		System.out.println(findCA(node, rightRoot1, rightRoot2)); 
	}
	
}
