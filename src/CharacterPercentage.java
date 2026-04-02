public class CharacterPercentage {

    public static void main(String[] args) {

        String input = "Java123@ Test";

        int upper = 0, lower = 0, digits = 0, special = 0;

        for (char c : input.toCharArray()) {

            if (Character.isUpperCase(c)) {
                upper++;
            } else if (Character.isLowerCase(c)) {
                lower++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                special++;
            }
        }

        int total = input.length();

        System.out.printf("Uppercase: %.2f%%\n", (upper * 100.0) / total);
        System.out.printf("Lowercase: %.2f%%\n", (lower * 100.0) / total);
        System.out.printf("Digits: %.2f%%\n", (digits * 100.0) / total);
        System.out.printf("Special Characters: %.2f%%\n", (special * 100.0) / total);
    }
}