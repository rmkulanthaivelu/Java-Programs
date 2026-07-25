import java.util.*;
import java.util.stream.Collectors;

public class FirstRepeatedNonRepeated {

    public static void main(String[] args) {

        String input = "JavaConceptOfTheDay";

        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count frequency
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Character firstNonRepeated = null;
        Character firstRepeated = null;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && firstNonRepeated == null) {
                firstNonRepeated = entry.getKey();
            }
            if (entry.getValue() > 1 && firstRepeated == null) {
                firstRepeated = entry.getKey();
            }
            if (firstNonRepeated != null && firstRepeated != null) {
                break;
            }
        }

        System.out.println("First Non-Repeated: " + firstNonRepeated);
        System.out.println("First Repeated: " + firstRepeated);


        String input1 = "JavaConceptOfTheDay".toLowerCase();
        Map.Entry<Character,Long> chars = input1.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()<=1)
                .findFirst().get();
        System.out.println("Repeated Chars:"+chars);
    }
}