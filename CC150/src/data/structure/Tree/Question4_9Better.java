package data.structure.Tree;

public class Question4_9Better {
	public static void findSum(TreeNode node, int sum, int[] path, int level) {
		if (node == null) return; 
		
		path[level]= node.name; 
		int t =0; 
		for (int i=level; i>=0; i--) {
			t+=path[i]; 
			if (t== sum) {
				print (path, i, level); 
			}
		}
		findSum(node.left, sum, path, level+1); 
		findSum(node.right, sum, path, level+1); 
		
		System.out.print("  end for findSum");
	}
	
	public static void findSum(TreeNode node, int sum){
		int depth = node.getHeight(); 
		int[] path = new int[depth+1]; 
		findSum(node, sum, path, 0); 
	}
	
	public static void print(int path[], int start, int end) {
		for (int i=start; i<=end; i++) {
			System.out.print("  " + path[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1); 
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3); 
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5); 
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7); 
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9); 
		TreeNode node10 = new TreeNode(10);
		node1.left = node2; node1.right = node3; 
		node2.left = node4; node2.right = node5; 
		node4.left = node6; node4.right = node7; 
		node5.right = node9; 
		node6.left = node8; node6.right = node10; 
		
		TreeNode sode2 = new TreeNode(12);
		
		TreeNode sode4 = new TreeNode(14);
		TreeNode sode5 = new TreeNode(15); 
		TreeNode sode6 = new TreeNode(16);
		TreeNode sode7 = new TreeNode(17); 
		
		TreeNode sode9 = new TreeNode(19); 
		TreeNode sode10 = new TreeNode(20);
		
		sode2.left = sode4; sode2.right = sode5; 
		sode4.left = sode6; sode4.right = sode7; 
		sode7.left = sode9; 
		sode6.right = sode10; 
		node5.left = sode2;
		
		findSum(node1, 16); 
}
}
