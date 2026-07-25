import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

    public static void main(String[] args) {

        String input = "Java J2EE Java JSP J2EE";

        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.forEach((k, v) ->
                System.out.println(k + " = " + v));
        System.out.println("============================");
        input.toLowerCase().chars().mapToObj(c->(char)c)
                .filter(c->c !=' ')
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
                .forEach(e->System.out.println(e.getKey()+"="+e.getValue()));
    }
}