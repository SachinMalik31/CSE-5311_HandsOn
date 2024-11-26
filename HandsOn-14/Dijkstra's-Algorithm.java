
import java.util.*;

class Edge {
    String target;
    int weight;

    Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, List<Edge>> graph, String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.weight > distances.get(current.target)) continue;

            for (Edge neighbor : graph.get(current.target)) {
                int newDist = distances.get(current.target) + neighbor.weight;
                if (newDist < distances.get(neighbor.target)) {
                    distances.put(neighbor.target, newDist);
                    pq.add(new Edge(neighbor.target, newDist));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        // Test graph
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("s", Arrays.asList(new Edge("t", 10), new Edge("y", 5)));
        graph.put("t", Arrays.asList(new Edge("x", 1), new Edge("y", 2)));
        graph.put("x", Arrays.asList(new Edge("z", 4)));
        graph.put("y", Arrays.asList(new Edge("t", 3), new Edge("x", 9), new Edge("z", 2)));
        graph.put("z", Arrays.asList(new Edge("x", 6), new Edge("s", 7)));

        Map<String, Integer> result = dijkstra(graph, "s");
        System.out.println("Shortest distances from node 's':");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println("To " + entry.getKey() + ": " + entry.getValue());
        }
    }
}


/*
Output :

Shortest distances from node 's':
 To s:  0
 To t:  8
 To x:  9
 To y:  5
 To z:  7

*/