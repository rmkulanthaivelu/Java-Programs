public class ReverseStringRecursive {

    public static void main(String[] args) {
        String input = "Hello";
        String reversed = reverse(input);
        System.out.println(reversed);
    }

    public static String reverse(String str) {
        // Base condition
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive call
        return reverse(str.substring(1)) + str.charAt(0);
    }
}