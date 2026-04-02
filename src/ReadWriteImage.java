import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ReadWriteImage {
    public static void main(String[] args) {
        try {
            // Specify the image file
            File inputFile = new File("input.jpg");

            // Read the image into BufferedImage
            BufferedImage image = ImageIO.read(inputFile);

            System.out.println("Image Read Successfully");
            System.out.println("Width: " + image.getWidth());
            System.out.println("Height: " + image.getHeight());

        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
        }
    }
}