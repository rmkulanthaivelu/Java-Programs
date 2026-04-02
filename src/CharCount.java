import java.util.HashMap;
import java.util.Map;

public class CharCount {

    public static void main(String[] args) {

        String input = "Java J2EE Java JSP J2EE";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.forEach((k, v) ->
                System.out.println(k + " = " + v));
    }
}