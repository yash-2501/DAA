import java.util.*;

public class AStar {

    static class Node
            implements Comparable<Node> {

        int vertex;
        double fScore;

        Node(
                int vertex,
                double fScore) {

            this.vertex = vertex;
            this.fScore = fScore;
        }

        @Override
        public int compareTo(Node other) {

            return Double.compare(
                this.fScore,
                other.fScore
            );
        }
    }

    public static List<Integer> findPath(
            Graph graph,
            int source,
            int destination,
            double[][] coordinates) {

        int n =
            graph.getVertices();

        double[] gScore =
            new double[n];

        double[] fScore =
            new double[n];

        int[] parent =
            new int[n];

        boolean[] closed =
            new boolean[n];

        Arrays.fill(
            gScore,
            Double.POSITIVE_INFINITY
        );

        Arrays.fill(
            fScore,
            Double.POSITIVE_INFINITY
        );

        Arrays.fill(
            parent,
            -1
        );

        PriorityQueue<Node> openSet =
            new PriorityQueue<>();

        gScore[source] = 0;

        fScore[source] =
            heuristic(
                source,
                destination,
                coordinates
            );

        openSet.add(
            new Node(
                source,
                fScore[source]
            )
        );

        while (!openSet.isEmpty()) {

            Node currentNode =
                openSet.poll();

            int current =
                currentNode.vertex;

            if (closed[current]) {
                continue;
            }

            if (current == destination) {

                return buildPath(
                    parent,
                    source,
                    destination
                );
            }

            closed[current] = true;

            for (Graph.Edge edge :
                    graph.getNeighbors(current)) {

                int next =
                    edge.destination;

                if (closed[next]) {
                    continue;
                }

                double tentativeGScore =
                    gScore[current]
                    + edge.weight;

                if (tentativeGScore <
                        gScore[next]) {

                    parent[next] =
                        current;

                    gScore[next] =
                        tentativeGScore;

                    fScore[next] =
                        tentativeGScore
                        + heuristic(
                            next,
                            destination,
                            coordinates
                        );

                    openSet.add(
                        new Node(
                            next,
                            fScore[next]
                        )
                    );
                }
            }
        }

        return new ArrayList<>();
    }

    private static double heuristic(
            int current,
            int destination,
            double[][] coordinates) {

        double x1 =
            coordinates[current][0];

        double y1 =
            coordinates[current][1];

        double x2 =
            coordinates[destination][0];

        double y2 =
            coordinates[destination][1];

        return Math.sqrt(
            Math.pow(x1 - x2, 2)
            + Math.pow(y1 - y2, 2)
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