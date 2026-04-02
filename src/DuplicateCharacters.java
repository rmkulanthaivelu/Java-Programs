import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String input = "Better Butter";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (c == ' ') continue; // ignore spaces
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Print duplicates
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}