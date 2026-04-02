import java.util.*;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "javaconceptoftheday";

        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;
        String result = "";

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));

            if (right - left + 1 > max) {
                max = right - left + 1;
                result = s.substring(left, right + 1);
            }
        }
        System.out.println(result); // oftheday
    }
}