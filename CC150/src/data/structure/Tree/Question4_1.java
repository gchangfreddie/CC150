package data.structure.Tree;

public class Question4_1 {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(24); 
		
		for (int i=0; i<10; i++) {
			if (i==8) continue; 
			root.add(new TreeNode(i * 2)); 
		}
		
		System.out.println("left is " + root.left.getHeight() + " right is " + root.right.getHeight());
		System.out.println(checkHeight(root));
		
		System.out.println("is BST " + root.isBST(0));
	}
	
	public static int checkHeight(TreeNode node) { 
		if (node == null) return 0; 
		int leftH = checkHeight(node.left); 
		if (leftH == -1) 
			return -1; 
		int rightH = checkHeight(node.right);
		if (rightH == -1 ) 
			return -1; 
		
		if (Math.abs(leftH-rightH)>1) 
			return -1; 
		return (Math.max(leftH, rightH)) +1; 
	}

}
