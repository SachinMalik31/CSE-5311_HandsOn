
import java.util.*;

class EdgeBF {
    String source, target;
    int weight;

    EdgeBF(String source, String target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
}

public class BellmanFord {
    public static Map<String, Integer> bellmanFord(List<EdgeBF> edges, String start, Set<String> nodes) {
        Map<String, Integer> distances = new HashMap<>();
        for (String node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (EdgeBF edge : edges) {
                if (distances.get(edge.source) != Integer.MAX_VALUE &&
                        distances.get(edge.source) + edge.weight < distances.get(edge.target)) {
                    distances.put(edge.target, distances.get(edge.source) + edge.weight);
                }
            }
        }

        for (EdgeBF edge : edges) {
            if (distances.get(edge.source) != Integer.MAX_VALUE &&
                    distances.get(edge.source) + edge.weight < distances.get(edge.target)) {
                throw new RuntimeException("Graph contains a negative-weight cycle.");
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        // Test graph
        List<EdgeBF> edges = Arrays.asList(
                new EdgeBF("A", "B", 4),
                new EdgeBF("A", "C", 2),
                new EdgeBF("B", "C", -2),
                new EdgeBF("B", "D", 2),
                new EdgeBF("C", "D", 3),
                new EdgeBF("D", "A", -4)
        );

        Set<String> nodes = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        try {
            Map<String, Integer> result = bellmanFord(edges, "A", nodes);
            System.out.println("Shortest distances from node 'A':");
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println("To " + entry.getKey() + ": " + entry.getValue());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*

Output :

Shortest distances from node 'A':
To A: 0
To B: 4
To C: 2
To D: 5


*/
