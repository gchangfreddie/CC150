package data.structure.Tree;

import java.util.LinkedList;

public class Question4_3 {
	
	public static void main(String[] args) {
		int[] a =new int[]{1,2,3,4, 5,6,7,8,9,10,11,12,13,14,15,16}; 

//		TreeNode first = new TreeNode(a[0]); 
//		for (int i=1; i<a.length;i++) {
//			first = first.addInOrder(new TreeNode(a[i])); 
//		}
		
		TreeNode first = insertInOrder(a, 0, a.length -1); 
		
		System.out.println(first.getHeight());
		
		System.out.println("is BST " + first.isBST(0));
		
		first.reverseTree(); 
		LinkedList<TreeNode>[] l = first.listArray; 
		
		for (int i=0; i<l.length; i++) {
			LinkedList<TreeNode> ll = l[i]; 
			for (int j=0; j<ll.size();j++) {
				System.out.print("  " + ll.get(j));
			}
			System.out.println();
		}
	}
	
	public static TreeNode insertInOrder(int[] a, int start, int end) {
		if (end<start) return null; 
//		if ((end-start) < 1) {
//			TreeNode node = new TreeNode(a[start]); // we don't need this one, the base case is end<start
//			return node; 
//		}
		int mid = start + (end-start)/2;
		TreeNode node = new TreeNode(a[mid]); 
		node.left = insertInOrder(a, start, mid-1); 
		node.right = insertInOrder(a, mid+1, end); 
		return node; 
	}
	
}


