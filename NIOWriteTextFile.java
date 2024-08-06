import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Demonstrates how to use Java NIO, a thread-safe File IO library
 * to write a text file
 */
public class NIOWriteTextFile {

    public static void main(String[] args) {
        // Test data the lines of the file we will write
        ArrayList<String> recs = new ArrayList<>();
        recs.add("Sample data for our file writing example.");
        recs.add("Sample data Line 2.");
        recs.add("Sample data Line 3.");
        recs.add("Sample data Line 4.");
        recs.add("Sample data Line 5.");

        // Get the current working directory
        File workingDirectory = new File(System.getProperty("user.dir"));
        // Create the file path within the working directory
        Path file = Paths.get(workingDirectory.getPath(), "src", "data.txt");

        try {
            // Wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            // Write the file
            for (String rec : recs) {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close(); // Close the file to seal it and flush the buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
