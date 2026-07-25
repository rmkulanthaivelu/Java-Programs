import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;

public class MergeIntreval {

    /*Input: intervals = {{1,3},{2,6},{8,10},{15,18}}
    Output: {{1,6},{8,10},{15,18}}
    Explanation: Since intervals {1,3} and {2,6} overlap, merge them into {1,6}.
    */
    public static void main(String args[]) {
        String s = "Hello World";
        String[] strLastWordArr = s.split(" ");
        String str = strLastWordArr[strLastWordArr.length - 1];
        System.out.println(str);

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] result = merge1(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }


    public static int[][] merge1(int[][] intervals) {
        // Sort by starting point
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(intervals));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            // Overlap condition
       //     System.out.println(next[0]+":"+current[1]);
            if (next[0] <= current[1]) {
                // Merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap
                result.add(current);
                current = next;
            }
        }
        // Add last interval
        result.add(current);
       return result.toArray(new int[result.size()][]);
    }
}