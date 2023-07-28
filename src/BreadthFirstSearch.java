import java.util.*;

import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(MyGraph<V> graph) {
        super(graph);
    }

    public List<Vertex<V>> bfsTraversal(Vertex<V> startVertex) {
        List<Vertex<V>> result = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.offer(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            result.add(currentVertex);

            for (Vertex<V> neighbor : graph.getNeighbors(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;
    }
}


