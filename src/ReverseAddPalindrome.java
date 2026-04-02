import java.util.Scanner;

public class ReverseAddPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int result = num;

        while (!isPalindrome(result)) {
            int reversed = reverse(result);
            result = result + reversed;

            System.out.println("Intermediate: " + result);
        }

        System.out.println("Palindrome: " + result);
    }

    // Check palindrome
    static boolean isPalindrome(int num) {
        return num == reverse(num);
    }

    // Reverse number
    static int reverse(int num) {
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }
}