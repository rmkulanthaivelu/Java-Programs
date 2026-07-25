public class SumOfDigits {
    public static void main(String[] args) {

        int number = 12345;
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;  // extract last digit
            sum = sum*10+digit;
            System.out.println(sum);
            number = number / 10;             // remove last digit
        }

        System.out.println("Sum of digits: " + sum);
    }
}