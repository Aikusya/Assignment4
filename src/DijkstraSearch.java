import java.util.*;

public class DijkstraSearch<V> extends Search<V> {

    public DijkstraSearch(MyGraph<V> graph) {
        super(graph);
    }

    public Map<Vertex<V>, Double> dijkstraShortestPath(Vertex<V> startVertex) {
        Map<Vertex<V>, Double> shortestDistances = new HashMap<>();
        PriorityQueue<DijkstraNode<V>> minHeap = new PriorityQueue<>();

        for (Vertex<V> vertex : graph.getVertices()) {
            shortestDistances.put(vertex, Double.POSITIVE_INFINITY);
        }

        shortestDistances.put(startVertex, 0.0);
        minHeap.offer(new DijkstraNode<>(startVertex, 0.0));

        while (!minHeap.isEmpty()) {
            DijkstraNode<V> currentNode = minHeap.poll();
            Vertex<V> currentVertex = currentNode.getVertex();
            double currentDistance = currentNode.getDistance();

            if (currentDistance > shortestDistances.get(currentVertex)) {
                continue;
            }

            for (Map.Entry<Vertex<V>, Double> entry : graph.getAdjacentVertices(currentVertex).entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double distance = currentDistance + weight;

                if (distance < shortestDistances.get(neighbor)) {
                    shortestDistances.put(neighbor, distance);
                    minHeap.offer(new DijkstraNode<>(neighbor, distance));
                }
            }
        }

        return shortestDistances;
    }
}
