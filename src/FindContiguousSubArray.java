import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindContiguousSubArray {
    public static void main(String[] args) {
        int[] array = {2, -3, 7, -4, 2, 5, -8, 6, -1};
        int targetSum = 10;
        findTheContiguousSubarray(array, targetSum);
        int[] array1 = {2, 4, 2, 8, 3, 3, 2, -4, 12};
        targetSum = 8;
        findTheContiguousAllSubarray(array1, targetSum);
        int[] array2 ={7, 5, 9, 3, 0, 8, 6};
        System.out.println("Finds triplets in the given array whose sum is equal to given number");
        targetSum =  12;
        findTheContiguousAllSubarray(array2, targetSum);
    }

    public static void findTheContiguousSubarray(int[] array, int targetSum) {
        // Find the contiguous subarray with maximum sum equal to the target sum
        Optional<int[]> result = IntStream.range(0, array.length)
                .boxed()
                .flatMap(start -> IntStream.range(start, array.length)
                        .mapToObj(end -> Arrays.copyOfRange(array, start, end))
                        .filter(subArray -> Arrays.stream(subArray).sum() == targetSum))
                .findFirst(); // If multiple such subarrays exist, find the first one.
        // Print the result
        if (result.isPresent()) {
            System.out.println("Subarray with sum " + targetSum + ": " + Arrays.toString(result.get()));
        } else {
            System.out.println("No subarray with sum " + targetSum + " found.");
        }
    }

    public static void findTheContiguousAllSubarray(int[] array, int targetSum) {
       IntStream.range(0,array.length).boxed()
                .flatMap(start->IntStream.range(start+1,array.length)
                 .mapToObj(end->Arrays.copyOfRange(array,start,end))
                        .filter(subarray->Arrays.stream(subarray).sum()==targetSum)
                ).forEach(val->System.out.println(Arrays.toString(val)));
    }
}