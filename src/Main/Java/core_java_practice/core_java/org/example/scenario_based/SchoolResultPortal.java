package Main.Java.core_java_practice.core_java.org.example.scenario_based;

import java.io.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            FileWriter fw = new FileWriter("reportcard.txt", true);

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(" ");

                String name = data[0];
                int m1 = Integer.parseInt(data[1]);
                int m2 = Integer.parseInt(data[2]);
                int m3 = Integer.parseInt(data[3]);

                double average = (m1 + m2 + m3) / 3.0;

                fw.write("Student: " + name + "\n");
                fw.write("Marks: " + m1 + " " + m2 + " " + m3 + "\n");
                fw.write("Average: " + average + "\n");
                fw.write("-------------------------\n");
            }

            br.close();
            fw.close();

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        } catch (IOException e) {
            System.out.println("File error occurred.");
        }
    }
}