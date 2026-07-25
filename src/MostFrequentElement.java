import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentElement {
    public static void main(String[] args) {
        int[] array = {4, 5, 2, 4, 5, 4, 3, 2, 4, 5, 5};

        Map.Entry<Integer,Long> mostNum = Arrays.stream(array).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        // Step 3: Print result
        System.out.println("Most frequent element: " + mostNum.getValue());
       // System.out.println("Frequency: " + maxFreq);

        // Step 1: Count frequency of each element using HashMap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the element with maximum frequency
        int maxFreq = 0;
        int mostFrequent = array[0];
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        // Step 3: Print result
        System.out.println("Most frequent element: " + mostFrequent);
        System.out.println("Frequency: " + maxFreq);
    }
}