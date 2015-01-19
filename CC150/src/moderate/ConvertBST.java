package moderate;

import java.util.LinkedList;

public class ConvertBST {

	public static TreeNode[] convert(TreeNode treeRoot) {
		TreeNode left = treeRoot, right = treeRoot; 
		if (treeRoot.pre == null && treeRoot.next == null) {
			return new TreeNode[]{treeRoot, treeRoot}; 
		}
		if (treeRoot.pre !=null) {
			TreeNode[] res = convert(treeRoot.pre); 
			left = res[0]; 
			res[1].next = treeRoot; 
			treeRoot.pre = res[1]; 
		}
		if (treeRoot.next!=null) {
			TreeNode[] res = convert(treeRoot.next); 
			right = res[1]; 
			res[0].pre = treeRoot; 
			treeRoot.next = res[0]; 
		}
		return new TreeNode[]{left, right}; 
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(4); 
		TreeNode left= new TreeNode(2); root.pre = left; 
		TreeNode right= new TreeNode(5); root.next = right; 
		TreeNode left1= new TreeNode(1); left.pre=left1; 
		TreeNode right1= new TreeNode(3); left.next = right1;
		TreeNode left0= new TreeNode(0); left1.pre = left0; 
		right.next = new TreeNode(6); 
		printTree(root); 
		System.out.println();
		TreeNode[] res = convert(root); 
		TreeNode resNode = res[0]; 
		print(resNode); 
	}
	
	public static void print(TreeNode root) {
		TreeNode pre = root; 
		while (root!=null) {
			System.out.print(root.value + " ->");
			pre = root; 
			root = root.next; 
		}
		System.out.println();
		while (pre!=null) {
			System.out.print(pre.value + " <-");
			pre = pre.pre; 
		}
	}
	
	public static void printTree(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<TreeNode>(); 
		q.add(root); 
		while(!q.isEmpty()) {
			TreeNode n = q.pop(); 
			System.out.print(n.value + " ");
			if (n.pre!=null) q.addLast(n.pre);
			if (n.next!=null) q.addLast(n.next);
		}
	}
}


class TreeNode{
	int value; 
	TreeNode pre, next; 
	
	TreeNode(int v){
		value = v; 
	}
}