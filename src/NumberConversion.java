public class NumberConversion {

    public static void main(String[] args) {

        int number = 25;

        String binary = Integer.toBinaryString(number);
        String octal = Integer.toOctalString(number);
        String hex = Integer.toHexString(number);

        System.out.println("Decimal: " + number);
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);
    }
}