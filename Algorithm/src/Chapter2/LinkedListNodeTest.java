package Chapter2;

public class LinkedListNodeTest {

	public static void main(String[] args) {
		LinkedListNode<String> node = new LinkedListNode<String>("Grace"); 
		node.add(new LinkedListNode<String>("Google")); 
		node.add(new LinkedListNode<String>("Facebook"));
		node.add(new LinkedListNode<String>("Yahoo")); 
		node.remove("Facebook");
		System.exit(0);
	}
}
