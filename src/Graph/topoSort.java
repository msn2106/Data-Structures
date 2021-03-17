/* Program to implement topological sorting in DAG*/
/*Time Complexity - O(V+E)
* Space - O(v) for stack*/
package Graph;
import java.util.*;

public class topoSort{
    private final Integer v;
    private final ArrayList<ArrayList<Integer>> graph;

    //constructor
    public topoSort(int vertex){
        this.v = vertex;
        graph = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
    }

    //adding edge - directed graph
    public void addEdge(int from, int to){
        graph.get(from).add(to);
    }

    //function for topological sort DFS way
    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();

        //making all vertices as not visited
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }

        //calling helper function to store the topological sort in stack
        //basically when there is no dependency left of the vertex then push it, after that push its source
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                topohelper(i,visited,stack);
            }
        }

        //printing the contents of stack
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }

    //helper function for topological sort
    public void topohelper(int v, boolean[] visited, Stack<Integer> stack){
        //mark the vertex visited
        visited[v] = true;

        //recur till the vertex with no dependency found in the adjacent of passed vertex
        for (Integer i : graph.get(v)) {
            if(!visited[i]){
                topohelper(i,visited,stack);
            }
        }
        //push the vertex, which has no pending dependency left
        stack.push(v);
    }

    //main driver function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = 6; //sc.nextInt();
        topoSort g = new topoSort(vertices);

        //adding edges
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort of the given nodes is:");
        g.topologicalSort();
        sc.close();
    }
}
