
import java.util.*;

public class TopologicalSort {
    private Map<String, List<String>> graph = new HashMap<>();

    // Add edge to the graph
    public void addEdge(String src, String dest) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
    }

    // Topological Sort
    public List<String> topologicalSort() {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (String vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, stack);
            }
        }

        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void dfs(String node, Set<String> visited, Stack<String> stack) {
        visited.add(node);
        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort();
        graph.addEdge("undershorts", "pants");
        graph.addEdge("undershorts", "shoes");
        graph.addEdge("pants", "belt");
        graph.addEdge("pants", "shoes");
        graph.addEdge("shirt", "tie");
        graph.addEdge("shirt", "belt");
        graph.addEdge("tie", "jacket");
        graph.addEdge("belt", "jacket");
        graph.addEdge("socks", "shoes");

        System.out.println("Topological Sort:");
        System.out.println(graph.topologicalSort());
    }
}
