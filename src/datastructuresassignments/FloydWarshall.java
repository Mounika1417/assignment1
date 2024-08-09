package datastructuresassignments;

public class FloydWarshall {
    final static int INF = 99999; // A value to represent infinity

    void floydWarshall(int graph[][], int vertices) {
        int dist[][] = new int[vertices][vertices];

        // Initialize the distance matrix with the input graph values
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Add all vertices one by one to the set of intermediate vertices
        for (int k = 0; k < vertices; k++) {
            // Pick all vertices as source one by one
            for (int i = 0; i < vertices; i++) {
                // Pick all vertices as destination for the above picked source
                for (int j = 0; j < vertices; j++) {
                    // If vertex k is on the shortest path from i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist, vertices);
    }

    void printSolution(int dist[][], int vertices) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int vertices = 4;
        int graph[][] = { 
            { 0, 5, INF, 10 }, 
            { INF, 0, 3, INF }, 
            { INF, INF, 0, 1 }, 
            { INF, INF, INF, 0 } 
        };

        fw.floydWarshall(graph, vertices);
    }
}

