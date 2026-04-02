import java.util.Scanner;

public class CheckNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input: ");

        String input = sc.nextLine();

        try {
            double num = Double.parseDouble(input);
            System.out.println("Valid number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }
}