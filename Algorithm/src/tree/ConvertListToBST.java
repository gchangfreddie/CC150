package tree;

public class ConvertListToBST {
	public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null; 
        ListNode n = head; 
        int count = 1; 
        while(n.next!=null) {
            n=n.next; 
            count++; 
        }
        return sort(head, 0, count-1).treeNode; 
    }
    
    public Wrapper sort(ListNode head, int start, int end){
        if (start>end) return null;
        int mid = start + (end-start)/2;
        Wrapper left = sort(head, start, mid-1); 
        if (left!=null) head= left.listNode;
        TreeNode root = new TreeNode(head.val); 
        root.left = left==null ? null : left.treeNode; 
        Wrapper right = sort(head.next, mid+1, end); 
        root.right = right==null? null : right.treeNode; 
        Wrapper res = new Wrapper(root, right==null? head.next : right.listNode); 
        return res;
    }
    
    public class Wrapper{
        TreeNode treeNode;
        ListNode listNode; 
        
        public Wrapper(TreeNode t , ListNode l) {
            treeNode = t; 
            listNode = l;
        }
    }
    
    public static void main(String[] args){
    	ListNode h = new ListNode(3); 
    	ListNode h1 = new ListNode(5); h.next = h1;
    	ListNode h2 = new ListNode(8); h1.next = h2;
    	ConvertListToBST c = new ConvertListToBST(); 
    	c.sortedListToBST(h); 
    }
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
}
