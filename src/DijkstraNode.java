public class DijkstraNode<V> implements Comparable<DijkstraNode<V>> {
    private final Vertex<V> vertex;
    private final double distance;

    public DijkstraNode(Vertex<V> vertex, double distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public Vertex<V> getVertex() {
        return vertex;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public int compareTo(DijkstraNode<V> other) {
        return Double.compare(this.distance, other.distance);
    }
}

