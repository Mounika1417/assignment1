package datastructuresassignments;

import java.util.*;

class Dijkstra {
    private static final int NO_PARENT = -1;

    // Function to find the vertex with the minimum distance value
    private int minDistance(int[] dist, boolean[] sptSet, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the shortest path from the source to a given vertex
    private void printPath(int currentVertex, int[] parents) {
        if (currentVertex == NO_PARENT) {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }

    // Function to print the solution
    private void printSolution(int source, int[] dist, int[] parents, int vertices) {
        System.out.println("Vertex\t Distance\tPath");

        for (int i = 0; i < vertices; i++) {
            if (i != source) {
                System.out.print(source + " -> " + i + "\t\t");
                System.out.print(dist[i] + "\t\t");
                printPath(i, parents);
                System.out.println();
            }
        }
    }

    // Function to implement Dijkstra's algorithm
    void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;

        int[] dist = new int[vertices];
        boolean[] sptSet = new boolean[vertices];
        int[] parents = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            parents[i] = NO_PARENT;
        }

        dist[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, sptSet, vertices);
            sptSet[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parents[v] = u;
                }
            }
        }

        printSolution(source, dist, parents, vertices);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { 
            { 0, 10, 20, 0, 0, 0 }, 
            { 10, 0, 5, 16, 0, 0 }, 
            { 20, 5, 0, 20, 10, 0 },
            { 0, 16, 20, 0, 5, 2 }, 
            { 0, 0, 10, 5, 0, 5 }, 
            { 0, 0, 0, 2, 5, 0 } 
        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0); // Source vertex is 0
    }
}
