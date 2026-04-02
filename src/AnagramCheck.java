import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {

        String s1 = "Mother In Law";
        String s2 = "Hitler Woman1";

        String str1 = s1.replaceAll("\\s+", "").toLowerCase();
        String str2 = s2.replaceAll("\\s+", "").toLowerCase();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isAnagram = Arrays.equals(arr1, arr2);

        System.out.println(isAnagram);
    }
}