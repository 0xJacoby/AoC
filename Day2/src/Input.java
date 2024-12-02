import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Input {
    public static String[] readLines(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            return lines.toArray(new String[0]);

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            e.printStackTrace();
            return new String[0];
        }
    }
}
