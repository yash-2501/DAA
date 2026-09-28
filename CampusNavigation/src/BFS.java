import java.util.*;

public class BFS {

    public static List<Integer> findPath(
            Graph graph,
            int source,
            int destination) {

        int n =
            graph.getVertices();

        boolean[] visited =
            new boolean[n];

        int[] parent =
            new int[n];

        Arrays.fill(
            parent,
            -1
        );

        Queue<Integer> queue =
            new LinkedList<>();

        queue.add(source);

        visited[source] = true;

        while (!queue.isEmpty()) {

            int current =
                queue.poll();

            if (current == destination) {
                break;
            }

            for (Graph.Edge edge :
                    graph.getNeighbors(current)) {

                int next =
                    edge.destination;

                if (!visited[next]) {

                    visited[next] = true;

                    parent[next] =
                        current;

                    queue.add(next);
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