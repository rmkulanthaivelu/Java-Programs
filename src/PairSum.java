import java.util.HashSet;
import java.util.Set;

public class PairSum {

    public static void main(String[] args) {

        int[] arr = {4, 5, 7, 11, 9, 13, 8, 12};
        int target = 20;

        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("(" + num + ", " + complement + ")");
            }

            seen.add(num);
        }
    }
}