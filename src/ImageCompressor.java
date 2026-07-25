
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ImageCompressor {

    public static void main(String[] args) {
        File inputFile = new File("E:\\PF Details\\SbiCheque.jpg");
        File outputFile = new File("E:\\PF Details\\compressed_output.jpg");

        try {
            compressToTargetSize(inputFile, outputFile, 100 * 1024); // 100 KB target
            System.out.println("Compression complete! File size: " + (outputFile.length() / 1024) + " KB");
        } catch (IOException e) {
            System.err.println("Error compressing image: " + e.getMessage());
        }
    }

    /**
     * Compresses a JPEG image dynamically until it falls below the target byte size.
     */
    public static void compressToTargetSize(File source, File destination, long targetBytes) throws IOException {
        BufferedImage image = ImageIO.read(source);

        // Locate JPEG Writer
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        if (!writers.hasNext()) {
            throw new IllegalStateException("No writers found for JPG format");
        }
        ImageWriter writer = writers.next();

        // Establish initial quality values
        float quality = 1.0f;
        long fileSize = Long.MAX_VALUE;

        // Loop until file size is under target or quality drops too low
        while (fileSize > targetBytes && quality > 0.05f) {
            try (OutputStream os = new FileOutputStream(destination);
                 ImageOutputStream ios = ImageIO.createImageOutputStream(os)) {

                writer.setOutput(ios);
                ImageWriteParam param = writer.getDefaultWriteParam();

                // Set explicit compression parameters
                if (param.canWriteCompressed()) {
                    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    param.setCompressionType("JPEG");
                    param.setCompressionQuality(quality);
                }

                // Write to temp file destination
                writer.write(null, new IIOImage(image, null, null), param);
                ios.flush();
            }

            // Re-evaluate file size
            fileSize = destination.length();

            // Degrade quality linearly by 10% blocks if target isn't met
            quality -= 0.10f;
        }

        writer.dispose();

        // Fallback: If image is still too large, downscaling the resolution is necessary
        if (fileSize > targetBytes) {
            System.out.println("Warning: Maximum compression reached. Consider reducing physical resolution.");
        }
    }
}