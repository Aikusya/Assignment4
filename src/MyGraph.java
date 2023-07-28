import java.util.*;

public class MyGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> list;

    public MyGraph() {
        list = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        list.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);
        list.get(source).add(destination);
        list.get(destination).add(source);

        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }

    public void removeEdge(Vertex<V> source, Vertex<V> destination) {
        if (!hasEdge(source, destination)) {
            System.out.println("These two vertices do not have an edge");
            return;
        }
        list.get(source).remove(destination);
        list.get(destination).remove(source);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);
        List<Vertex<V>> neighbors = list.get(source);
        return neighbors != null && neighbors.contains(destination);
    }

    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return list.getOrDefault(vertex, new LinkedList<>());
    }

    public Set<Vertex<V>> getVertices() {
        return list.keySet();
    }

    public Map<Vertex<V>, Double> getAdjacentVertices(Vertex<V> vertex) {
        validateVertex(vertex);
        Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();
        for (Vertex<V> neighbor : list.getOrDefault(vertex, new LinkedList<>())) {
            adjacentVertices.put(neighbor, vertex.getAdjacentVertices().get(neighbor));
        }
        return adjacentVertices;
    }

    private void validateVertex(Vertex<V> vertex) {
        if (!list.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }

    public void printGraph() {
        for (Map.Entry<Vertex<V>, List<Vertex<V>>> entry : list.entrySet()) {
            Vertex<V> vertex = entry.getKey();
            System.out.print("Vertex " + vertex.getData() + " connected to: ");
            List<Vertex<V>> neighbors = entry.getValue();
            for (Vertex<V> neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }
    }
}

