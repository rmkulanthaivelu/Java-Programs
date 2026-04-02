import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyTextFile {
    public static void main(String[] args) {
        Path filePath = Paths.get("example.txt");
        String target = "oldText";   // Text to be replaced
        String replacement = "newText"; // Replacement text

        try {
            // Step 1: Read all lines from the file
            List<String> lines = Files.readAllLines(filePath);

            // Step 2: Replace target string in each line
            List<String> modifiedLines = lines.stream()
                    .map(line -> line.replace(target, replacement))
                    .collect(Collectors.toList());

            // Step 3: Write modified content back to the file
            Files.write(filePath, modifiedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("File modified successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}