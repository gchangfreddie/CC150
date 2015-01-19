package Chapter2;

public class Question2 {
	public int value = 0; 
	
	public static void main(String[] args) {
		LinkedListNode<String> node = new LinkedListNode<String>("Grace"); 
		node.add(new LinkedListNode<String>("Grace")); 
		node.add(new LinkedListNode<String>("Google")); 
		node.add(new LinkedListNode<String>("Facebook"));
		node.add(new LinkedListNode<String>("Yahoo")); 
		node.add(new LinkedListNode<String>("LinkedIn"));
		node.add(new LinkedListNode<String>("Zillow")); 
		
		LinkedListNode<String> res = nthToLastR2(node, 3, new Question2()); 
		System.out.println(res.data);
		System.exit(0);
	}
	
	public static LinkedListNode<String> nthToLastR2(LinkedListNode<String> h, int k, Question2 i){
		if (h == null) 
			return null; 
		LinkedListNode<String> node = nthToLastR2(h.next, k, i); 
		i.value = i.value + 1; 
		if (i.value == k) 
			return h; 
		return node; 
	}
}
