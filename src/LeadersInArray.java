import java.util.*;

public class LeadersInArray {

    public static void main(String[] args) {
        int[] arr = {14, 9, 11, 7, 8, 5, 3};
        List<Integer> leaders = new ArrayList<>();
        int maxFromRight = arr[arr.length - 1];
        leaders.add(maxFromRight); // rightmost always leader
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // reverse to maintain original order
        Collections.reverse(leaders);

        System.out.println(leaders);
    }
}