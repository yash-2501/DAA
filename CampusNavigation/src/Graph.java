import java.util.*;

public class Graph {

    static class Edge {

        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private final int vertices;

    private final List<List<Edge>> adjacencyList;

    // ==========================================
    // Constructor
    // ==========================================

    public Graph(int vertices) {

        this.vertices = vertices;

        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {

            adjacencyList.add(
                new ArrayList<>()
            );
        }
    }

    // ==========================================
    // Add Edge
    // ==========================================

    public void addEdge(
            int source,
            int destination,
            int weight) {

        adjacencyList
            .get(source)
            .add(
                new Edge(
                    destination,
                    weight
                )
            );

        // Undirected graph
        adjacencyList
            .get(destination)
            .add(
                new Edge(
                    source,
                    weight
                )
            );
    }

    // ==========================================
    // Get Neighbors
    // ==========================================

    public List<Edge> getNeighbors(
            int vertex) {

        return adjacencyList.get(vertex);
    }

    // ==========================================
    // Get Number of Vertices
    // ==========================================

    public int getVertices() {

        return vertices;
    }

    // ==========================================
    // Display Graph
    // ==========================================

    public void displayGraph() {

        System.out.println();
        System.out.println(
            "========== CAMPUS GRAPH =========="
        );

        for (int i = 0; i < vertices; i++) {

            System.out.print(
                i + " -> "
            );

            for (Edge edge :
                    adjacencyList.get(i)) {

                System.out.print(
                    edge.destination
                    + "("
                    + edge.weight
                    + "m) "
                );
            }

            System.out.println();
        }

        System.out.println(
            "=================================="
        );
    }
}