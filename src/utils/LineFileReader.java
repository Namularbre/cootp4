package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineFileReader {
    /**
     *
     * @param fileName the name of the file to read
     * @throws FileNotFoundException if file is not found
     * @throws NumberFormatException if file is null
     * @return a list of string containing each line of the file
     */
    public static List<String> ReadAllByLines(String fileName) throws FileNotFoundException {
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);

        // content of the file
        List<String> lines = new ArrayList<>();
        // Read file line by line
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}
