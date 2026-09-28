import java.io.*;

public class CampusDataLoader {

    public static Graph loadGraph(
            String filePath,
            int numberOfVertices) {

        Graph graph =
            new Graph(numberOfVertices);

        try {

            BufferedReader reader =
                new BufferedReader(
                    new FileReader(filePath)
                );

            String line;

            while ((line = reader.readLine())
                    != null) {

                line = line.trim();

                // Ignore empty lines
                if (line.isEmpty()) {
                    continue;
                }

                // Ignore comments
                if (line.startsWith("#")) {
                    continue;
                }

                String[] parts =
                    line.split(",");

                if (parts.length != 3) {

                    System.out.println(
                        "Invalid data line: "
                        + line
                    );

                    continue;
                }

                int source =
                    Integer.parseInt(
                        parts[0].trim()
                    );

                int destination =
                    Integer.parseInt(
                        parts[1].trim()
                    );

                int weight =
                    Integer.parseInt(
                        parts[2].trim()
                    );

                graph.addEdge(
                    source,
                    destination,
                    weight
                );
            }

            reader.close();

            System.out.println(
                "Campus data loaded successfully."
            );

        } catch (FileNotFoundException e) {

            System.out.println(
                "Campus data file not found:"
            );

            System.out.println(filePath);

            System.exit(1);

        } catch (IOException e) {

            System.out.println(
                "Error reading campus data."
            );

            e.printStackTrace();

            System.exit(1);

        } catch (NumberFormatException e) {

            System.out.println(
                "Invalid number in campus data file."
            );

            e.printStackTrace();

            System.exit(1);
        }

        return graph;
    }
}