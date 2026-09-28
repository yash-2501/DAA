import java.io.*;
import java.util.*;

public class PerformanceAnalyzer {

    static class Result {

        String algorithm;
        int source;
        int destination;
        int edges;
        int distance;
        long time;

        Result(
                String algorithm,
                int source,
                int destination,
                int edges,
                int distance,
                long time) {

            this.algorithm = algorithm;
            this.source = source;
            this.destination = destination;
            this.edges = edges;
            this.distance = distance;
            this.time = time;
        }
    }

    public static List<Result> runTest(
            Graph graph,
            int source,
            int destination,
            double[][] coordinates) {

        List<Result> results =
            new ArrayList<>();

        long start =
            System.nanoTime();

        List<Integer> bfsPath =
            BFS.findPath(
                graph,
                source,
                destination
            );

        long bfsTime =
            System.nanoTime() - start;

        results.add(
            createResult(
                "BFS",
                source,
                destination,
                graph,
                bfsPath,
                bfsTime
            )
        );

        start =
            System.nanoTime();

        List<Integer> dfsPath =
            DFS.findPath(
                graph,
                source,
                destination
            );

        long dfsTime =
            System.nanoTime() - start;

        results.add(
            createResult(
                "DFS",
                source,
                destination,
                graph,
                dfsPath,
                dfsTime
            )
        );

        start =
            System.nanoTime();

        List<Integer> dijkstraPath =
            Dijkstra.findPath(
                graph,
                source,
                destination
            );

        long dijkstraTime =
            System.nanoTime() - start;

        results.add(
            createResult(
                "Dijkstra",
                source,
                destination,
                graph,
                dijkstraPath,
                dijkstraTime
            )
        );

        start =
            System.nanoTime();

        List<Integer> aStarPath =
            AStar.findPath(
                graph,
                source,
                destination,
                coordinates
            );

        long aStarTime =
            System.nanoTime() - start;

        results.add(
            createResult(
                "A*",
                source,
                destination,
                graph,
                aStarPath,
                aStarTime
            )
        );

        return results;
    }

    private static Result createResult(
            String algorithm,
            int source,
            int destination,
            Graph graph,
            List<Integer> path,
            long time) {

        int edges = 0;
        int distance = 0;

        if (path != null &&
            !path.isEmpty()) {

            edges =
                path.size() - 1;

            distance =
                calculateDistance(
                    graph,
                    path
                );
        }

        return new Result(
            algorithm,
            source,
            destination,
            edges,
            distance,
            time
        );
    }

    private static int calculateDistance(
            Graph graph,
            List<Integer> path) {

        int total = 0;

        for (int i = 0;
             i < path.size() - 1;
             i++) {

            int current =
                path.get(i);

            int next =
                path.get(i + 1);

            for (Graph.Edge edge :
                    graph.getNeighbors(current)) {

                if (edge.destination == next) {

                    total +=
                        edge.weight;

                    break;
                }
            }
        }

        return total;
    }

    public static void displayResults(
            List<Result> results) {

        System.out.println();

        System.out.println(
            "=============================================================="
        );

        System.out.println(
            "                 PERFORMANCE ANALYSIS"
        );

        System.out.println(
            "=============================================================="
        );

        System.out.printf(
            "%-12s %-10s %-15s %-15s%n",
            "Algorithm",
            "Edges",
            "Distance(m)",
            "Time(ns)"
        );

        System.out.println(
            "--------------------------------------------------------------"
        );

        for (Result result : results) {

            System.out.printf(
                "%-12s %-10d %-15d %-15d%n",
                result.algorithm,
                result.edges,
                result.distance,
                result.time
            );
        }

        System.out.println(
            "=============================================================="
        );
    }

    public static void saveToCSV(
            List<Result> results,
            String filePath) {

        try {

            File file =
                new File(filePath);

            File parent =
                file.getParentFile();

            if (parent != null) {
                parent.mkdirs();
            }

            FileWriter writer =
                new FileWriter(file);

            writer.write(
                "Algorithm,Source,Destination,"
                + "Edges,Distance,ExecutionTimeNs\n"
            );

            for (Result result : results) {

                writer.write(
                    result.algorithm
                    + ","
                    + result.source
                    + ","
                    + result.destination
                    + ","
                    + result.edges
                    + ","
                    + result.distance
                    + ","
                    + result.time
                    + "\n"
                );
            }

            writer.close();

            System.out.println();

            System.out.println(
                "Results saved successfully:"
            );

            System.out.println(
                filePath
            );

        } catch (IOException e) {

            System.out.println(
                "Error while saving CSV file."
            );

            e.printStackTrace();
        }
    }
}