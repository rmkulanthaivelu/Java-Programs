public class BinaryCheck {

    public static void main(String[] args) {

        int number = 101101;
        boolean isBinary = true;

        while (number > 0) {
            int digit = number % 10;

            if (digit != 0 && digit != 1) {
                isBinary = false;
                break;
            }

            number /= 10;
        }

        System.out.println(isBinary);
    }
}