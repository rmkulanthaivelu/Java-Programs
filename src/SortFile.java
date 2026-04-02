import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class SortFile {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("input.txt"));

        List<String> sorted = lines.stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("output.txt"), sorted);
    }
}