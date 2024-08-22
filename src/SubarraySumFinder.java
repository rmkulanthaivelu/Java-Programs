import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubarraySumFinder {

    public static void main(String[] args) {
        int[] a = {-1, -2, 3, 5, -7, 2, 9,-11};

        // Finding all subarrays whose sum equals 0
        List<int[]> subarraysWithZeroSum =
                IntStream.range(0, a.length).boxed()
                .flatMap(start -> IntStream.range(start, a.length)
                        .mapToObj(end -> new int[]{start, end})
                )
                .filter(indices -> {
                    int start = indices[0];
                    int end = indices[1];
                    int sum = IntStream.rangeClosed(start, end)
                            .map(i -> a[i])
                            .sum();
                    return sum == 0;
                })
                .collect(Collectors.toList());

        // Displaying the start and end indices of subarrays with sum 0
        subarraysWithZeroSum.forEach(indices ->
                System.out.println("Subarray with sum 0 found from index " + indices[0] + " to " + indices[1])
        );
       for(int[] i : subarraysWithZeroSum)
           System.out.println(i[0]+":"+i[1]);

    }
}
