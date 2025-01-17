package datastructuresassignments;

import java.util.*;

class Edge1 {
    int source, destination, weight;

    public Edge1(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalMST {
    int vertices, edges;
    Edge[] edgeList;

    KruskalMST(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeList = new Edge[edges];
    }

    void addEdge(int index, int source, int destination, int weight) {
        edgeList[index] = new Edge(source, destination, weight);
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i = 0;

        for (i = 0; i < vertices; ++i)
            result[i] = new Edge(0, 0, 0);

        Arrays.sort(edgeList, new Comparator<Edge>() {
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });

        Subset[] subsets = new Subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;
        while (e < vertices - 1) {
            Edge nextEdge = edgeList[i++];
            int x = find(subsets, nextEdge.source);
            int y = find(subsets, nextEdge.destination);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].source + " -- " + result[i].destination + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree " + minimumCost);
    }

    public static void main(String[] args) {
        int vertices = 4; // Number of vertices in the graph
        int edges = 5; // Number of edges in the graph
        KruskalMST graph = new KruskalMST(vertices, edges);

        // Adding edges: source, destination, weight
        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }
}
