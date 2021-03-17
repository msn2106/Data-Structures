/*This is a program to implement Adjacency matrix representation for undirected graph*/

package Graph;

import java.util.Scanner;

public class AdjMatrix {
	int vertices;
	int[][] adjmat;
	
	public AdjMatrix(int v) {
		this.vertices = v;
		adjmat = new int[v][v];
	}
	
	public void addEdge(int source, int destination) {
		adjmat[source][destination] = 1;
		adjmat[destination][source] = 1;
	}
	
	public void printGraph() {
		for(int i=0;i<vertices;i++) {
			for(int j=0;j<vertices;j++) {
				System.out.print(adjmat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		int V = sc.nextInt();
		AdjMatrix adj = new AdjMatrix(V);
		
		System.out.println("Enter the number of edges:");
		int E = sc.nextInt();
		
		for(int i=0;i<E;i++) {
			System.out.println("Enter the source vertex:");
			int source = sc.nextInt();
			System.out.println("Enter the destination vertex:");
			int destination = sc.nextInt();
			
			adj.addEdge(source, destination);
			
		}
		System.out.println("Adjacency Matrix:");
		adj.printGraph();
		sc.close();
	}
}
