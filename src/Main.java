public class Main {

    public static void main(String[] args) {
        MyGraph<Integer> myGraph = new MyGraph<>();
        Vertex<Integer> vertex0 = new Vertex<>(0);
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);

        myGraph.addVertex(vertex0);
        myGraph.addVertex(vertex1);
        myGraph.addVertex(vertex2);
        myGraph.addVertex(vertex3);
        myGraph.addVertex(vertex4);

        myGraph.addEdge(vertex0, vertex1, 1.0);
        myGraph.addEdge(vertex0, vertex2, 1.0);
        myGraph.addEdge(vertex0, vertex3, 1.0);
        myGraph.addEdge(vertex0, vertex4, 1.0);
        myGraph.addEdge(vertex1, vertex2, 1.0);
        myGraph.addEdge(vertex2, vertex3, 1.0);
        myGraph.addEdge(vertex3, vertex4, 1.0);
        myGraph.addEdge(vertex1, vertex4, 1.0);

        System.out.println("____________Before removing________________");
        myGraph.printGraph();

        myGraph.removeEdge(vertex0, vertex3);
        System.out.println("____________After removing________________");
        myGraph.printGraph();
        myGraph.removeEdge(vertex0, vertex3);
        System.out.println("Vertex 0 has next neighbors: " + myGraph.getNeighbors(vertex0));
    }
}
