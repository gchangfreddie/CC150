package data.structure.Tree;

import java.util.LinkedList;

public class Question4_8 {
	public static boolean isSubTree(TreeNode root, TreeNode s) {
		boolean res = false; 
		
		LinkedList<TreeNode> l = new LinkedList<TreeNode>(); 
		l.add(root); 
		while(!l.isEmpty()) {
			TreeNode p = l.removeFirst(); 
			if (p.left != null) l.addLast(p.left);
			if (p.right != null ) l.addLast(p.right); 
			if (p.name == s.name){
				res = compare(p, s);
				if (res) break; 
			}
		}
		return res; 
	}
	
	public static boolean compare(TreeNode p, TreeNode s) {
		if (s == null) return true; 
		if (p== null) return false; 
		if (p.name != s.name) return false;
		return compare(p.right, s.right) && compare(p.left, s.left) ; 
		
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
		
		TreeNode sode2 = new TreeNode(2);
		
		TreeNode sode4 = new TreeNode(4);
		TreeNode sode5 = new TreeNode(5); 
		TreeNode sode6 = new TreeNode(6);
		TreeNode sode7 = new TreeNode(7); 
		
		TreeNode sode9 = new TreeNode(9); 
		TreeNode sode10 = new TreeNode(10);
		
		sode2.left = sode4; sode2.right = sode5; 
		sode4.left = sode6; sode4.right = sode7; 
		sode7.left = sode9; 
		sode6.right = sode10; 
		
		System.out.println(isSubTree(node1, sode2)); 
	}
	
}
