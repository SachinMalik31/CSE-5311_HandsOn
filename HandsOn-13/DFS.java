
import java.util.*;

public class DFS {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add edge to the graph
    public void addEdge(String src, String dest) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
    }

    // Recursive DFS
    public void dfsRecursive(String start, Set<String> visited) {
        visited.add(start);
        System.out.println("Visited: " + start);
        for (String neighbor : graph.getOrDefault(start, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // Iterative DFS
    public void dfsIterative(String start) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.println("Visited: " + node);
                for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS dfsGraph = new DFS();
        dfsGraph.addEdge("u", "v");
        dfsGraph.addEdge("u", "x");
        dfsGraph.addEdge("v", "y");
        dfsGraph.addEdge("x", "v");
        dfsGraph.addEdge("y", "x");

        // Recursive DFS
        System.out.println("Recursive DFS:");
        dfsGraph.dfsRecursive("u", new HashSet<>());
        
        // Iterative DFS
        System.out.println("\nIterative DFS:");
        dfsGraph.dfsIterative("u");
    }
}
