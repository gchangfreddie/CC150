package data.structure.Tree;

import java.util.HashSet;
import java.util.Set;

import org.xml.sax.HandlerBase;

public class Question4_2 {

	public static void main(String[] args) {
		Graph g = new Graph(); 
		
		Node n1 = new Node(1); Node n2 = new Node(2); Node n3 = new Node(3); Node n4 = new Node(4);  
		Node n5 = new Node(5); Node n6 = new Node(6); Node n7 = new Node(7); Node n8 = new Node(8); 
		Node n9 = new Node(9); Node n10 = new Node(10);
		 
		HashSet<Node> s = new HashSet<Node>(); s.add(n2); s.add(n8); s.add(n5); n1.addAdj(s); 
		s = new HashSet<Node>(); s.add(n3); s.add(n6); n2.addAdj(s); 
		s = new HashSet<Node>(); s.add(n4); n3.addAdj(s);
		s = new HashSet<Node>(); s.add(n6); n4.addAdj(s);
		s = new HashSet<Node>(); s.add(n7); s.add(n1);  n6.addAdj(s);
		s = new HashSet<Node>(); s.add(n3); n7.addAdj(s);
		s = new HashSet<Node>(); s.add(n4); n9.addAdj(s);
		s = new HashSet<Node>(); s.add(n1); n10.addAdj(s);
		
		boolean[] marked = new boolean[10]; 
		marked[n1.name] = true; // mark s is very important, otherwise there is a loop 
		findRoute(g, n1, n7, marked);
	}
	
	public static boolean findRoute(Graph g, Node s, Node d, boolean[] marked) {
		Set<Node> sAdj = s.getAdjacent();
		
		for (Node n: sAdj) {
			if (!marked[n.name]){
				if (n==d) {
					System.out.print(d);
					return true;
				}
				marked[n.name] = true;
				if (findRoute(g,n,d, marked)){
					System.out.print(" " + n);
					return true; 
				}
			}
		}
		return false; 
	}
}
