public class ArmstrongNumber {

    public static void main(String[] args) {

        int number = 153;  // change input here
        int original = number;

        int digits = String.valueOf(number).length(); // count digits
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        if (sum == original) {
            System.out.println(original + " is an Armstrong number");
        } else {
            System.out.println(original + " is NOT an Armstrong number");
        }
    }
}