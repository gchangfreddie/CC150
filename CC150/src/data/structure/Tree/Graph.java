package data.structure.Tree;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	Set<Node> nodeSet = new HashSet<Node>();  
	
	public Set<Node> getNodes() {
		return nodeSet; 
	}
	
	public void addNode(Node n) {
		nodeSet.add(n); 
	}
}

class Node {
	Set<Node> adjSet;
	int name; 
	
	Node(int i) {
		name = i; 
		adjSet = new HashSet<Node>(); 
	}
	
	public void addAdj(Set<Node> nodes) {
		adjSet.addAll(nodes); 
	}
	
	public Set<Node> getAdjacent() {
		return adjSet; 
	}
	
	public String toString() {
		return String.valueOf(name); 
	}
}