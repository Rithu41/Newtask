import java.io.*;

public class MarksCalculator {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("marks.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                int total = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                }

                double average = (double) total / (parts.length - 1);
                writer.write(name + " " + String.format("%.2f", average));
                writer.newLine();
            }

            reader.close();
            writer.close();
            System.out.println("Results written to results.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
