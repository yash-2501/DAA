import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class PerformanceGraph
        extends JPanel {

    static class Data {

        String algorithm;
        long time;

        Data(
                String algorithm,
                long time) {

            this.algorithm = algorithm;
            this.time = time;
        }
    }

    private final List<Data> data =
        new ArrayList<>();

    public PerformanceGraph(
            String filePath) {

        loadCSV(filePath);
    }

    private void loadCSV(
            String filePath) {

        try {

            BufferedReader reader =
                new BufferedReader(
                    new FileReader(filePath)
                );

            String line;

            // Skip header
            reader.readLine();

            while ((line =
                    reader.readLine()) != null) {

                String[] parts =
                    line.split(",");

                if (parts.length >= 6) {

                    String algorithm =
                        parts[0];

                    long time =
                        Long.parseLong(
                            parts[5]
                        );

                    data.add(
                        new Data(
                            algorithm,
                            time
                        )
                    );
                }
            }

            reader.close();

        } catch (Exception e) {

            System.out.println(
                "Error reading results.csv"
            );

            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(
            Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 =
            (Graphics2D) g;

        int width =
            getWidth();

        int height =
            getHeight();

        int left = 80;
        int bottom = height - 80;
        int top = 60;
        int right = width - 50;

        g2.setFont(
            new Font(
                "Arial",
                Font.BOLD,
                22
            )
        );

        g2.drawString(
            "Algorithm Performance Comparison",
            220,
            35
        );

        g2.drawLine(
            left,
            top,
            left,
            bottom
        );

        g2.drawLine(
            left,
            bottom,
            right,
            bottom
        );

        if (data.isEmpty()) {

            g2.drawString(
                "No data available.",
                300,
                250
            );

            return;
        }

        long maxTime = 0;

        for (Data d : data) {

            if (d.time > maxTime) {
                maxTime = d.time;
            }
        }

        if (maxTime == 0) {
            maxTime = 1;
        }

        int barWidth = 100;
        int gap = 40;

        int x = left + 50;

        for (Data d : data) {

            int barHeight =
                (int) (
                    ((double) d.time
                    / maxTime)
                    * (bottom - top - 40)
                );

            int y =
                bottom - barHeight;

            g2.fillRect(
                x,
                y,
                barWidth,
                barHeight
            );

            g2.setFont(
                new Font(
                    "Arial",
                    Font.PLAIN,
                    14
                )
            );

            g2.drawString(
                d.algorithm,
                x + 20,
                bottom + 25
            );

            g2.drawString(
                d.time + " ns",
                x - 5,
                y - 10
            );

            x +=
                barWidth + gap;
        }

        g2.drawString(
            "Execution Time (ns)",
            10,
            120
        );

        g2.drawString(
            "Algorithms",
            width / 2 - 40,
            height - 20
        );
    }

    public static void main(
            String[] args) {

        String filePath =
            "results/results.csv";

        JFrame frame =
            new JFrame(
                "Campus Navigation - Performance"
            );

        PerformanceGraph graph =
            new PerformanceGraph(
                filePath
            );

        frame.add(graph);

        frame.setSize(
            900,
            600
        );

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(
            null
        );

        frame.setVisible(true);
    }
}