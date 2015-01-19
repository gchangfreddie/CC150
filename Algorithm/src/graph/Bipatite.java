package graph;

import java.util.*;

public class Bipatite {
	public boolean isBipatiteBFS(Graph a){
		if (a==null) return false; 
		Queue<Integer> q = new LinkedList<Integer>(); 
		int num = a.nodes.size();
		int[] color = new int[num];
		boolean[] marked = new boolean[num]; 
		color[a.nodes.get(0)] = 1; 
		q.add(a.nodes.get(0)); 
		marked[a.nodes.get(0)]=true; 
		while (!q.isEmpty()) {
			int n = q.remove(); 
			List<Integer> nodes = a.graph.get(n); 
			for (int w : nodes) {
				if (!marked[w]){
					marked[w] = true; 
					q.add(w) ;
					color[w] = -color[n]; 
				} else if (color[w]==color[n]) {
					return false; 
				}
			}
		}
		return true; 
	}
	
	public boolean isBipatiteDFS(Graph a) {
		int num = a.nodes.size();
		boolean[] marked= new boolean[num]; 
		int[] color = new int[num]; 
		
		int src = a.nodes.get(0); 
		color[src] = 1; 
		marked[src] = true; 
		
		return isBipatite(a, marked, src, color); 
 	}
	
	public boolean isBipatite(Graph a, boolean[] marked, int v, int color[]) {
		for (int n : a.graph.get(v)){
			if (!marked[n]) {
				marked[n] = true;
				color[n] = -color[v];
				if (!isBipatite(a, marked, n, color)) return false; 
			} else if (color[n]==color[v]) return false; 
		}
		return true; 
	}
	
	public List<Integer> findCycles(Graph a) {
		int num = a.nodes.size(); 
		boolean[] marked = new boolean[num]; 
		int src = a.nodes.get(0); 
		marked[src] = true; 
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(src); 
		return findCycles(a, marked, list, src, -1); 
	}
	
	public List<Integer> findCycles(Graph a, boolean[] marked, List<Integer> list, int src, int prev) {
		for (int n : a.graph.get(src)) {
			if (!marked[n]){
				marked[n] = true; 
				list.add(n); 
				return findCycles(a, marked, list, n, src); 
			} else {
				if (prev != n) {
					list.add(n); 
					return list;
				}
			}
		}
		return null; 
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(new int[][] {{0, 1, 1, 0, 0, 1, 1},
		        {1, 0, 0, 1, 0, 0, 0},
		        {1, 0, 0, 1, 1, 0, 0},
		        {0, 1, 1, 0, 0, 0, 0},
		        {0, 0, 1, 0, 0, 1, 1}, 
		        {1, 0, 0, 0, 1, 0, 0}, 
		        {1, 0, 0, 0, 1, 0, 0}
		}); 
		System.out.println(new Bipatite().isBipatiteBFS(g));
		System.out.println(new Bipatite().isBipatiteDFS(g));
	}
}


class Graph{
	List<Integer> nodes = new ArrayList<Integer>(); 
	HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	int[][] matrix; 
	
    Graph(HashMap<Integer, List<Integer>> g) {
		graph = g; 
		for (Map.Entry<Integer, List<Integer>> entry: g.entrySet()) {
			nodes.add(entry.getKey()); 
		}
	}
    
    Graph(int[][] m) {
    	matrix = m; 
    	for (int i=0; i<m.length;i++) {
    		nodes.add(i); 
    		List<Integer> a = new ArrayList<Integer>();
    		for (int j=0; j<m[i].length; j++) {
    			if (m[i][j] ==1) a.add(j); 
    		}
    		graph.put(i, a); 
    	}
    }
}
