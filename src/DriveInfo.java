import java.io.File;

public class DriveInfo {

    public static void main(String[] args) {

        File[] drives = File.listRoots();

        for (File drive : drives) {

            System.out.println("Drive: " + drive);

            long total = drive.getTotalSpace();
            long free = drive.getFreeSpace();
            long usable = drive.getUsableSpace();

            System.out.println("Total Space: " + total / (1024 * 1024 * 1024) + " GB");
            System.out.println("Free Space: " + free / (1024 * 1024 * 1024) + " GB");
            System.out.println("Usable Space: " + usable / (1024 * 1024 * 1024) + " GB");

            System.out.println("-----------------------------------");
        }
    }
}