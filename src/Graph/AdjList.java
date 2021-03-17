/*This is a program to implement Adjacency list representation for undirected graph*/
package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class AdjList {
	int V;
	ArrayList<ArrayList<Integer>>adj;
	
	//constructor
	public AdjList(int v) {
		this.V = v;
		adj = new ArrayList<ArrayList<Integer>>(v);
		for(int i=0;i<v;i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	//function to add edge in undirected graph
	public void addEdge(int u, int v) {
		adj.get(u).add(v);	//on this place adjacency matrix had 1
		adj.get(v).add(u);	//in case of directed graph this line is not there
	}
	
	public void printGraph() {
		for(int i=0;i<adj.size();i++) {
			System.out.println("Adjacency list of vertex "+i);
			System.out.print("head");
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(" -> "+ adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	//function for BFS traversal
	public void BFS(int start) {
		boolean visited[] = new boolean[V];
		
		//create a queue for BFS
		Queue<Integer> q = new LinkedList<Integer>();
		//mark the current node as visited and enqueue it
		visited[start] = true;
		q.add(start);
		System.out.println("BFS Traversal:");
		
		while(q.isEmpty() == false) {
			int node = q.poll();
			System.out.print(node+" ");
			
			//traversing the graph every element
			for(int x : adj.get(node)) {
				if(visited[x]==false) {
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}
	
	//recursive function for DFS to traversal all the unvisited nodes
	void dfsUtil(int node, boolean visited[]) {
		visited[node]=true;
		System.out.print(node+" ");
		for(int x: adj.get(node)) {
			if(visited[x]==false) {
				dfsUtil(x, visited);
			}
		}
	}
	//function for DFS traversal - Time Complexity O(V+E) and Space Complexity - O(V)
	public void DFS(int start) {
		boolean visited[] = new boolean[V];
		System.out.println("DFS Traversal:");
		for (int i=0; i<V; ++i) 
            if (visited[i] == false) 
                dfsUtil(i, visited); 
		//dfsUtil(start, visited); - only line sufficient for non-disconnected graph
	}
	
	//driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertex:");
		int V = sc.nextInt();
		AdjList adj = new AdjList(V);
		
		
		//adding edges
		adj.addEdge(0, 1);
		adj.addEdge(0, 4); 
        adj.addEdge(1, 2); 
        adj.addEdge(1, 3); 
        adj.addEdge(1, 4); 
        adj.addEdge(2, 3); 
        adj.addEdge(3, 4);
        
        adj.printGraph();
        
        adj.DFS(0);
        System.out.println();
        adj.BFS(0);
        sc.close();
	}
}
