import java.util.*;

public class DFS {

    public static List<Integer> findPath(
            Graph graph,
            int source,
            int destination) {

        boolean[] visited =
            new boolean[
                graph.getVertices()
            ];

        int[] parent =
            new int[
                graph.getVertices()
            ];

        Arrays.fill(
            parent,
            -1
        );

        dfs(
            graph,
            source,
            destination,
            visited,
            parent
        );

        return buildPath(
            parent,
            source,
            destination
        );
    }

    private static boolean dfs(
            Graph graph,
            int current,
            int destination,
            boolean[] visited,
            int[] parent) {

        visited[current] = true;

        if (current == destination) {
            return true;
        }

        for (Graph.Edge edge :
                graph.getNeighbors(current)) {

            int next =
                edge.destination;

            if (!visited[next]) {

                parent[next] =
                    current;

                if (dfs(
                        graph,
                        next,
                        destination,
                        visited,
                        parent)) {

                    return true;
                }
            }
        }

        return false;
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