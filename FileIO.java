import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The program will read information from a file
 * then it will try to convert it into string and
 * then split the string into an array of integers.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-03-06
 */
public final class FileIO {

    /** Constant for the input file. */
    private static final String INPUT_FILE = "input.txt";
    /** Constant for the output file. */
    private static final String OUTPUT_FILE = "output.txt";

    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private FileIO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main Method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) throws Exception {
        // Pass the path to the file as a parameter
        try (Scanner sc = new Scanner(new File(INPUT_FILE));
             FileWriter writer = new FileWriter(OUTPUT_FILE)) {

        // Reading file line by line
        while (sc.hasNextLine()) {
        String line = sc.nextLine();
        String output;

            if (line.trim().isEmpty()) {
                output = "Line is empty.";
            } else {
            // Splitting the line into an array of strings
            String[] numbers = line.split(" ");
                try {
                int sum = 0;
                // Converting each string to an integer and summing them up
                for (String num : numbers) {
                sum += Integer.parseInt(num);
                }
                    output = "Sum: " + sum;
                } catch (NumberFormatException error) {
                        output = "Invalid number format in input file.";
                }
            }

                // Writing the result to the output file
                writer.write(output + "\n");
            }

        } catch (IOException error) {
            //File read and write errors
        System.out.print("Error reading or writing files: ");
        System.out.println(error.getMessage());
        }
    }
}
