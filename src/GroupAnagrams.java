import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //Map<String, List<String>> grouped =
                Arrays.stream(words)
                .collect(Collectors.groupingBy(GroupAnagrams::getWord))
                .entrySet().stream().forEach(System.out::println);
       // System.out.println(grouped.values());
    }

    public static String  getWord(String word){
         char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
    }
}