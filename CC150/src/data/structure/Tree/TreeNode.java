package data.structure.Tree;

import java.util.LinkedList;

public class TreeNode {
	TreeNode left, right, root; 
	int name; 
	int height=-1; 
	LinkedList<TreeNode>[] listArray ;  
	LinkedList<TreeNode> a = new LinkedList<TreeNode>(); 
	
	TreeNode(int name) {
		this.name = name; 
	}
	
	public String toString() {
		return String.valueOf(this.name); 
	}
	
	public int getHeight() {
		if (height >= 0) return height; 
		if (this.left==null && this.right == null) height= 0; 
		else if (this.left == null) height= this.right.getHeight()+1;
		else if (this.right == null) height = this.left.getHeight() + 1; 
		else height = (Math.max(this.left.getHeight(), this.right.getHeight()) + 1); 
		return height; 
	}
	
	public void add(TreeNode n) {
		if (this.left == null) this.left = n; 
		else if (this.right == null) this.right = n;
		else {
			if (n.name %3 == 0 )
			this.left.add(n); 
			else this.right.add(n); 
		}
	}
	
	public TreeNode addInOrder(TreeNode n) {
		if (this.left != null && this.right== null) {
			this.right = n; 
			return this; 
		}  else {
			if (this.left != null && this.right != null && this.left.getHeight() > this.right.getHeight()) {
				n.left = this.right; 
				this.right = n; 
				return this; 
			} else {
				n.left = this; 
				return n; 
			}
		}
	}
	
	public boolean isBalancedBad() { //this is NOT correct, because we did NOT detect all the subtrees are balanced
		return Math.abs(this.left.getHeight() - this.right.getHeight()) <=1; 
	}

	public void reverseTree(){
		listArray = new LinkedList[this.getHeight()+1]; 
		for (int i=0; i< listArray.length; i++) {
			listArray[i] = new LinkedList<TreeNode>(); 
		}
		
		reverse(0, this); 
		
	}
	
	private void reverse(int layer, TreeNode n){
		if (n == null) return; 
		reverse(layer+1, n.left); 
		reverse(layer+1, n.right); 
		listArray[layer].add(n); 
	}

	public boolean isBST(int lastPrint) {
		if (this.name < lastPrint ) 
			return false; 
		if (this.left == null && this.right == null ) return true; 
		boolean res = true; 
		if (this.left!= null) 
			res = res && (this.left.name < this.name) && this.left.isBST(lastPrint); 
		
		lastPrint = this.name;
		
		if (this.right != null) 
			res = res && (this.right.name > this.name) && this.right.isBST(lastPrint); 
		return res;  
	}
	
	public TreeNode findNextNode() {
		if (this.right == null) return null; 
		else return this.right.nextNode(); 
	}
	
	private TreeNode nextNode() {
		if (this.left == null) return this; 
		return this.left.nextNode(); 
	}
	
	public void convertToList(TreeNode n) {
		if(n == null) return; 
		convertToList(n.left); 
		a.addLast(n); 
		convertToList(n.right); 
	}
	
	public boolean isBSTree(TreeNode n, int min, int max) {
		if (n == null) return true; 
		if (n.name >= max || n.name <= min) return false; 
		return  isBSTree(n.left, min, n.name) && isBSTree(n.right, n.name, max); 
	}
}
