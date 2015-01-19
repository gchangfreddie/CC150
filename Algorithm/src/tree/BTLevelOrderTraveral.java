package tree;

import java.util.*;
public class BTLevelOrderTraveral {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if (root==null) return res; 
        level(root, res, 0); 
        Collections.reverse(res);
        return res; 
    }
    
    public void level(TreeNode root, List<List<Integer>> res, int depth) {
        if (res.size()<=depth) {
            res.add(new ArrayList<Integer>()); 
        }
        if (root.left !=null) level(root.left, res, depth+1); 
        if (root.right!=null) level(root.right, res, depth+1); 
        res.get(depth).add(root.val); 
    }
    
    public static void main(String[] args) {
    	BTLevelOrderTraveral b = new BTLevelOrderTraveral(); 
    	TreeNode t3 = new TreeNode(3); 
    	TreeNode t9 = new TreeNode(9); 
    	TreeNode t20 = new TreeNode(20); t3.left = t9; t3.right=t20; 
    	TreeNode t15 = new TreeNode(15); 
    	TreeNode t7 = new TreeNode(7); t20.left = t15; t20.right=t7;
    	
    	List<List<Integer>> res = b.levelOrderBottom(t3); 
    	for (List<Integer> list  : res) {
    		System.out.println(list);
    	}
    }
}
