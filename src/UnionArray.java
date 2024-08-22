import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class UnionArray {
    public static void main(String[] args)
    {
        int[] inputArray1 = {2, 3, 4, 7, 1};
        int[] inputArray2 = {4, 1, 3, 5};
        int[] inputArray3 = {8, 4, 6, 2, 1};
        int[] inputArray4 = {7, 9, 4, 1};
        union(inputArray1, inputArray2, inputArray3, inputArray4);
    }
    public static void union(int[] ... intArr){
        Set<Integer> setVal = new TreeSet<>(Arrays.stream(intArr[0]).boxed().collect(Collectors.toSet()));
            for(int[] i:intArr){
            Set<Integer> setInt = new HashSet<>(Arrays.stream(i).boxed().collect(Collectors.toSet()));
            setVal.retainAll(setInt);
        }
        System.out.println(setVal);
    }
}
