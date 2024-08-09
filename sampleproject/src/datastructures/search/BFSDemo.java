package datastructures.search;


import java.util.LinkedList;
import java.util.Queue;

class Graph{
	int vertices;
	LinkedList<Integer>[] adjList;
	
	Graph(int vertices){
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for(int i = 0; i< vertices; ++i) {
			adjList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int u,int v) {
		adjList[u].add(v);
	}
	
	void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[vertices];
		
		visited[startNode] = true;
		queue.add(startNode);
		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");
			for(int neighbor: adjList[currentNode]){
				if( !visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
	
}
public class BFSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vertices = 5;
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3 );
		graph.addEdge(1, 4 );
		graph.addEdge(2, 4 );
		
		System.out.println("Breadth First Traversal starting from vertex 0: ");
		graph.bfs(2);
		
	}

}