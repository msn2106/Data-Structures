/*This is a program to detect a cycle in undirected graph.*/
package Graph;
import java.util.ArrayList;
import java.util.Scanner;
public class DetectCycle1 {

	int V;
	ArrayList<ArrayList<Integer>> graph;
	
	public DetectCycle1(int v) {
		this.V = v;
		graph = new ArrayList<ArrayList<Integer>>(v);
		for(int i=0;i<v;i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	void addEdge(int start, int end) {
		graph.get(start).add(end);
		graph.get(end).add(start);
	}
	
	void printGraph() {
		for(int i=0;i<graph.size();i++) {
			System.out.println("Adjacency List for vertex:"+i);
			System.out.print("Head");
			for(int j=0;j<graph.get(i).size();j++) {
				System.out.print("-> "+ graph.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	//recursive function that uses visible[] and parent to detect cycle in subgraph reachable from vertex v
	boolean isCyclicUtil(int v, boolean[] visited, int parent) {
		visited[v] = true;		//mark the current node as visited
		for(int i : graph.get(v)) {
			//if the adjacent node is not visited then recur for it.
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, v))
					return true;
			}
			//if the adjacent is visited and not the parent of current vertex, then there is a cycle
			else if(i!=parent)
				return true;
		}
		return false;
	}
	
	//function to detect cycle - time complexity - O(V+E) and space complexity - O(v)
	public boolean detectCycle() {
		boolean visited[] = new boolean[V];
		//mark all the vertices as not visited and not a part of recursion stack
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		//call the recursive utility function to detect a cycle in different DFS tree
		for(int i=0;i<V;i++) {
			if(!visited[i]) { //don't recur for i if already visited	
				if(isCyclicUtil(i,visited,-1))
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Number of vertices:");
//		int v = sc.nextInt();
		int v = 5;
		DetectCycle1 g = new DetectCycle1(v);
		
		//adding edge
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		//g.addEdge(2, 0);
		g.addEdge(3, 4);
		//g.addEdge(1, 4);
		
		g.printGraph();
		System.out.println();
		System.out.println("Is there a cycle:"+ g.detectCycle());
		sc.close();
	}
}
