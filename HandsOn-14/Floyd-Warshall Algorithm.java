
import java.util.Arrays;

public class FloydWarshall {
    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, n);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    private static void printSolution(int[][] dist) {
        System.out.println("Shortest distances matrix:");
        for (int[] row : dist) {
            for (int val : row) {
                System.out.print((val == INF ? "INF" : val) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test graph
        int[][] graph = {
                {0, 3, INF, 8, -4},
                {INF, 0, INF, 1, 7},
                {INF, 4, 0, INF, INF},
                {2, INF, -5, 0, INF},
                {INF, INF, INF, 6, 0}
        };

        floydWarshall(graph);
    }
}


/*

Output :

Shortest distances matrix:
  0   1  -3  2  -4 
 INF 0 -4  1  -1 
 INF 4  0  5  3 
  2  -1 -5  0 -2 
  8   5  1  6  0 


*/