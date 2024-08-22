import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindSecondLargest {
    public static void main(String[] args)
    {
        secondLargest(new int[] {45, 51, 28, 75, 49, 42});
        secondLargest(new int[] {985, 521, 975, 831, 479, 861});
        secondLargest(new int[] {9459, 9575, 5692, 1305, 1942, 9012});
        secondLargest(new int[] {47498, 14526, 74562, 42681, 75283, 45796});
    }
    public static void secondLargest(int[] intArr){
        List<Integer> SecondLargest = Arrays.stream(intArr).boxed()
                .distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
                //.skip(1).findFirst().get();
        System.out.println(SecondLargest.get(0)+":"+SecondLargest.get(1));
    }
}
