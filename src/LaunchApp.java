public class LaunchApp {

    public static void main(String[] args) {

        try {
            // Launch Notepad
            Runtime.getRuntime().exec("notepad");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}