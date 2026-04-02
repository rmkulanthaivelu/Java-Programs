import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int sumOfDigits = 0;
        int temp = number;

        // Step 1: Calculate sum of digits
        while (temp != 0) {
            sumOfDigits += temp % 10;
            temp /= 10;
        }

        // Step 2: Check divisibility
        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad (Niven) number.");
        } else {
            System.out.println(number + " is NOT a Harshad (Niven) number.");
        }
    }
}