import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class SecondLargest {

    public static void main(String[] args) {

        int[] arr = {21, 20, 4, 45, 99};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println("Second Largest: " + secondLargest);

        int secondLargest1 = Arrays.stream(arr).boxed().distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst().get();

        System.out.println("Second Largest: " + secondLargest1);
    }
}