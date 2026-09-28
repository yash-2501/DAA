import java.util.*;

public class Dijkstra {

    static class Node
            implements Comparable<Node> {

        int vertex;
        int distance;

        Node(
                int vertex,
                int distance) {

            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {

            return Integer.compare(
                this.distance,
                other.distance
            );
        }
    }

    public static List<Integer> findPath(
            Graph graph,
            int source,
            int destination) {

        int n =
            graph.getVertices();

        int[] distance =
            new int[n];

        int[] parent =
            new int[n];

        Arrays.fill(
            distance,
            Integer.MAX_VALUE
        );

        Arrays.fill(
            parent,
            -1
        );

        PriorityQueue<Node> pq =
            new PriorityQueue<>();

        distance[source] = 0;

        pq.add(
            new Node(
                source,
                0
            )
        );

        while (!pq.isEmpty()) {

            Node current =
                pq.poll();

            int vertex =
                current.vertex;

            if (current.distance !=
                    distance[vertex]) {

                continue;
            }

            if (vertex == destination) {
                break;
            }

            for (Graph.Edge edge :
                    graph.getNeighbors(vertex)) {

                int next =
                    edge.destination;

                int newDistance =
                    distance[vertex]
                    + edge.weight;

                if (newDistance <
                        distance[next]) {

                    distance[next] =
                        newDistance;

                    parent[next] =
                        vertex;

                    pq.add(
                        new Node(
                            next,
                            newDistance
                        )
                    );
                }
            }
        }

        return buildPath(
            parent,
            source,
            destination
        );
    }

    private static List<Integer> buildPath(
            int[] parent,
            int source,
            int destination) {

        List<Integer> path =
            new ArrayList<>();

        if (source != destination &&
            parent[destination] == -1) {

            return path;
        }

        int current =
            destination;

        while (current != -1) {

            path.add(current);

            if (current == source) {
                break;
            }

            current =
                parent[current];
        }

        Collections.reverse(path);

        return path;
    }
}