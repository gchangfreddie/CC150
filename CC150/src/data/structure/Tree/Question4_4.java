package data.structure.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

import data.structure.StackQueue.Queue;

public class Question4_4 {
	public static void main(String[] args) {
		int[] a =new int[]{1,2,3,4, 5,6, 7, 8, 9, 10, 11, 12, 13,14,15}; 

		TreeNode first = new TreeNode(a[0]); 
		for (int i=1; i<a.length;i++) {
			first = first.addInOrder(new TreeNode(a[i])); 
		}
		
		// iterate level by level, when we go to level n, we suppose all nodes in level n-1 has be stored in list.
		ArrayList<LinkedList<TreeNode>> all = new ArrayList<LinkedList<TreeNode>>(); 
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>(); 
		nodeQueue.addFirst(first); 
		while(!nodeQueue.isEmpty()) {
			all.add(nodeQueue); // prev layer
			LinkedList<TreeNode> parent = nodeQueue; 
			nodeQueue = new LinkedList<TreeNode>(); 
			for (int i=0; i<parent.size(); i++) {
				TreeNode n = parent.get(i); 
				if (n.left != null) nodeQueue.add(n.left) ;
				if (n.right != null) nodeQueue.add(n.right); 
			}
		}
		
		first.reverseTree(); 
		LinkedList<TreeNode>[] l = first.listArray; 
		
		for (int i=0; i<l.length; i++) {
			LinkedList<TreeNode> ll = l[i]; 
			for (int j=0; j<ll.size();j++) {
				System.out.print("  " + ll.get(j));
			}
			System.out.println();
		}
		
		System.out.println("is BST " + first.isBST(0));
		
		System.out.println(first.left.right.findNextNode());
	}
	
	/*Queue q=new Queue();
	q.push(root);
	while (!q.isEmpty()) {
		node=q.pop();
		if (node.left!=null) q.push(node.left); 
		if (node.right!=null) q.push(node.right);
	} */

}
