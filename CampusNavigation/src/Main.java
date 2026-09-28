import java.util.*;

public class Main {

    static String[] locations = {
        "Main Gate",
        "Admin Building",
        "IT Department",
        "Library",
        "Canteen",
        "Laboratory",
        "Parking",
        "Auditorium",
        "Sports Ground",
        "Hostel"
    };

    // Coordinates used by A*
    static double[][] coordinates = {
        {0, 0},
        {80, 0},
        {180, 0},
        {240, 0},
        {80, 100},
        {180, 70},
        {150, 170},
        {300, 80},
        {400, 180},
        {250, 170}
    };

    static Graph graph;

    public static void main(String[] args) {

        String dataFile = "data/campus_data.txt";

        // Load campus graph
        graph = CampusDataLoader.loadGraph(
            dataFile,
            locations.length
        );

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            displayMenu();

            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println();
                System.out.println(
                    "Invalid input! Please enter a number."
                );

                scanner.nextLine();
                choice = 0;
            }

            switch (choice) {

                case 1:
                    displayLocationMapping();
                    break;

                case 2:
                    displayLocationMapping();
                    graph.displayGraph();
                    break;

                case 3:
                    runBFS(scanner);
                    break;

                case 4:
                    runDFS(scanner);
                    break;

                case 5:
                    runDijkstra(scanner);
                    break;

                case 6:
                    runAStar(scanner);
                    break;

                case 7:
                    compareAlgorithms(scanner);
                    break;

                case 8:

                    System.out.println();
                    System.out.println(
                        "Thank you for using Campus Navigation System!"
                    );

                    break;

                default:

                    System.out.println();
                    System.out.println(
                        "Invalid choice! Please select 1-8."
                    );
            }

        } while (choice != 8);

        scanner.close();
    }

    // ================= MENU =================

    static void displayMenu() {

        System.out.println();

        System.out.println(
            "=============================================="
        );

        System.out.println(
            "       CAMPUS NAVIGATION & PATH FINDING"
        );

        System.out.println(
            "=============================================="
        );

        System.out.println(
            "1. Display Campus Location IDs"
        );

        System.out.println(
            "2. Display Campus Graph"
        );

        System.out.println(
            "3. Find Path using BFS"
        );

        System.out.println(
            "4. Find Path using DFS"
        );

        System.out.println(
            "5. Find Shortest Path using Dijkstra"
        );

        System.out.println(
            "6. Find Path using A*"
        );

        System.out.println(
            "7. Compare All Algorithms"
        );

        System.out.println(
            "8. Exit"
        );

        System.out.println(
            "=============================================="
        );
    }

    // ================= LOCATION MAPPING =================

    static void displayLocationMapping() {

        System.out.println();

        System.out.println(
            "========== LOCATION ID MAPPING =========="
        );

        for (int i = 0; i < locations.length; i++) {

            System.out.println(
                i + " -> " + locations[i]
            );
        }

        System.out.println(
            "=========================================="
        );
    }

    // ================= SOURCE & DESTINATION =================

    static int[] getSourceDestination(
            Scanner scanner) {

        displayLocationMapping();

        int source;
        int destination;

        // Source
        while (true) {

            System.out.print(
                "Enter Source ID: "
            );

            try {

                source = scanner.nextInt();

                if (source >= 0 &&
                    source < locations.length) {

                    break;
                }

                System.out.println(
                    "Invalid Source ID! Please enter 0-9."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Enter a number."
                );

                scanner.nextLine();
            }
        }

        // Destination
        while (true) {

            System.out.print(
                "Enter Destination ID: "
            );

            try {

                destination = scanner.nextInt();

                if (destination >= 0 &&
                    destination < locations.length) {

                    break;
                }

                System.out.println(
                    "Invalid Destination ID! Please enter 0-9."
                );

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Enter a number."
                );

                scanner.nextLine();
            }
        }

        return new int[] {
            source,
            destination
        };
    }

    // ================= BFS =================

    static void runBFS(Scanner scanner) {

        int[] input =
            getSourceDestination(scanner);

        int source = input[0];
        int destination = input[1];

        long start = System.nanoTime();

        List<Integer> path =
            BFS.findPath(
                graph,
                source,
                destination
            );

        long end = System.nanoTime();

        long time = end - start;

        System.out.println();

        System.out.println(
            "========== BFS RESULT =========="
        );

        printPath(path);

        System.out.println(
            "Number of Edges: "
            + Math.max(0, path.size() - 1)
        );

        System.out.println(
            "Distance: "
            + calculateDistance(path)
            + " m"
        );

        System.out.println(
            "Execution Time: "
            + time
            + " ns"
        );

        System.out.println(
            "================================"
        );
    }

    // ================= DFS =================

    static void runDFS(Scanner scanner) {

        int[] input =
            getSourceDestination(scanner);

        int source = input[0];
        int destination = input[1];

        long start = System.nanoTime();

        List<Integer> path =
            DFS.findPath(
                graph,
                source,
                destination
            );

        long end = System.nanoTime();

        long time = end - start;

        System.out.println();

        System.out.println(
            "========== DFS RESULT =========="
        );

        printPath(path);

        System.out.println(
            "Number of Edges: "
            + Math.max(0, path.size() - 1)
        );

        System.out.println(
            "Distance: "
            + calculateDistance(path)
            + " m"
        );

        System.out.println(
            "Execution Time: "
            + time
            + " ns"
        );

        System.out.println(
            "================================"
        );
    }

    // ================= DIJKSTRA =================

    static void runDijkstra(Scanner scanner) {

        int[] input =
            getSourceDestination(scanner);

        int source = input[0];
        int destination = input[1];

        long start = System.nanoTime();

        List<Integer> path =
            Dijkstra.findPath(
                graph,
                source,
                destination
            );

        long end = System.nanoTime();

        long time = end - start;

        System.out.println();

        System.out.println(
            "======= DIJKSTRA RESULT ========"
        );

        printPath(path);

        System.out.println(
            "Number of Edges: "
            + Math.max(0, path.size() - 1)
        );

        System.out.println(
            "Shortest Distance: "
            + calculateDistance(path)
            + " m"
        );

        System.out.println(
            "Execution Time: "
            + time
            + " ns"
        );

        System.out.println(
            "================================"
        );
    }

    // ================= A* =================

    static void runAStar(Scanner scanner) {

        int[] input =
            getSourceDestination(scanner);

        int source = input[0];
        int destination = input[1];

        long start = System.nanoTime();

        List<Integer> path =
            AStar.findPath(
                graph,
                source,
                destination,
                coordinates
            );

        long end = System.nanoTime();

        long time = end - start;

        System.out.println();

        System.out.println(
            "========== A* RESULT =========="
        );

        printPath(path);

        System.out.println(
            "Number of Edges: "
            + Math.max(0, path.size() - 1)
        );

        System.out.println(
            "Distance: "
            + calculateDistance(path)
            + " m"
        );

        System.out.println(
            "Execution Time: "
            + time
            + " ns"
        );

        System.out.println(
            "================================"
        );
    }

    // ================= PERFORMANCE COMPARISON =================

    static void compareAlgorithms(
            Scanner scanner) {

        int[] input =
            getSourceDestination(scanner);

        int source = input[0];
        int destination = input[1];

        System.out.println();

        System.out.println(
            "Running performance comparison..."
        );

        List<PerformanceAnalyzer.Result> results =
            PerformanceAnalyzer.runTest(
                graph,
                source,
                destination,
                coordinates
            );

        PerformanceAnalyzer.displayResults(
            results
        );

        PerformanceAnalyzer.saveToCSV(
            results,
            "results/results.csv"
        );
    }

    // ================= PRINT PATH =================

    static void printPath(
            List<Integer> path) {

        if (path == null ||
            path.isEmpty()) {

            System.out.println(
                "No path found."
            );

            return;
        }

        System.out.print("Path: ");

        for (int i = 0;
             i < path.size();
             i++) {

            int id = path.get(i);

            System.out.print(
                id
                + " ["
                + locations[id]
                + "]"
            );

            if (i < path.size() - 1) {

                System.out.print(
                    " -> "
                );
            }
        }

        System.out.println();
    }

    // ================= CALCULATE DISTANCE =================

    static int calculateDistance(
            List<Integer> path) {

        if (path == null ||
            path.size() < 2) {

            return 0;
        }

        int totalDistance = 0;

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

                    totalDistance +=
                        edge.weight;

                    break;
                }
            }
        }

        return totalDistance;
    }
}