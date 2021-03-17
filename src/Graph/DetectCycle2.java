/* This is a program to detect a cycle in directed graph*/
package Graph;

import java.util.List;

public class DetectCycle2 extends AdjList{
	
	public DetectCycle2(int v) {
		super(v);
	}
	
	//function to add edge from source to destination
	public void addEdge(int source, int destination) {
		adj.get(source).add(destination);
	}
	
	//recursive function to check cycle 
	public boolean isCyclic(int i,boolean[] visited, boolean[] recStack) {
		//mark the current node visited and part of recursion stack
		if(recStack[i]) return true;
		if(visited[i]) return false;
		
		visited[i]=true;
		
		recStack[i]=true;
		List<Integer> children = adj.get(i);
		for(Integer x: children) {
			if(isCyclic(x, visited, recStack))
				return true;
		}
		recStack[i] = false;
		return false;
	}
	
	//return true if graph contains cycle else return false
	public boolean detectCycle() {
		//mark all vertices not visited and not a part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		//call the recursive helper function to detect cycle in different DFS trees
		for(int i=0;i<V;i++) {
			if(isCyclic(i,visited,recStack))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int v = 5;
		DetectCycle2 g = new DetectCycle2(v);
		
		//adding edges
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		//g.addEdge(2, 0);
		g.addEdge(3, 4);
		//g.addEdge(1, 4);
		
		g.printGraph();
		
		g.BFS(0);
		System.out.println();
		System.out.println("Is there a cycle:"+ g.detectCycle());
	}
}
