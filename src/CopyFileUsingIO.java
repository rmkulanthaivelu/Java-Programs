import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileUsingIO {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(destFile)) {

            int ch;
            while ((ch = fr.read()) != -1) {
                fw.write(ch);
            }

            System.out.println("File copied successfully using FileReader/FileWriter.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}