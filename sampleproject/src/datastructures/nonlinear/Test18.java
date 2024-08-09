package datastructures.nonlinear;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GraphDemo{
	private Map<String,List<String>> adjlist;
	
	//constructor
	public GraphDemo() {
		//Map to store adjacency list for each vertex
		adjlist = new HashMap<>();
	}
	
	//Add a vertex
	public void addVertex(String vertex) {
		adjlist.putIfAbsent(vertex, new ArrayList<>());
	}
	//Add an Edge
	public void addEdge(String vertex1,String vertex2){
		adjlist.putIfAbsent(vertex1, new ArrayList<>());
		adjlist.putIfAbsent(vertex2, new ArrayList<>());
		adjlist.get(vertex1).add(vertex2);
		adjlist.get(vertex2).add(vertex1);
	}
	
	//Print the Graph
	public void printGraph() {
		for(String vertex: adjlist.keySet()) {
			System.out.print(vertex + " -> ");
			for(String neighbor: adjlist.get(vertex)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}
}

public class Test18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphDemo graph = new GraphDemo();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		
		graph.printGraph();
	}

}