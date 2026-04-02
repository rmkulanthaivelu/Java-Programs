import java.io.File;

public class FileReadOnlyExample {
    public static void main(String[] args) {
        File file = new File("example.txt");

        // Create the file if it doesn't exist
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Make the file read-only
            boolean readOnlySet = file.setReadOnly();
            if (readOnlySet) {
                System.out.println("File is now read-only.");
            } else {
                System.out.println("Failed to make file read-only.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}