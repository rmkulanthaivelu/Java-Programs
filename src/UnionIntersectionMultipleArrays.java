import java.util.*;
import java.util.stream.*;

/**
78) How to find union and intersection of multiple arrays in Java?

You have seen union and intersection of two arrays. In this post, you will see union and intersection of multiple arrays.
**/

public class UnionIntersectionMultipleArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
        int[] arr3 = {4, 5, 6, 7};

        List<int[]> allArrays = Arrays.asList(arr1, arr2, arr3);

        // ---- UNION ----
        Set<Integer> union = allArrays.stream()
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(Collectors.toSet());

        System.out.println("Union: " + union);

        // ---- INTERSECTION ----
        // Start with first array
        Set<Integer> intersection = Arrays.stream(arr1).boxed().collect(Collectors.toSet());

        for (int i = 1; i < allArrays.size(); i++) {
            Set<Integer> currentSet = Arrays.stream(allArrays.get(i)).boxed().collect(Collectors.toSet());
            intersection.retainAll(currentSet); // keep only common elements
        }

        System.out.println("Intersection: " + intersection);
    }
}