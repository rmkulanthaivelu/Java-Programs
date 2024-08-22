import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumAbsoluteDifference {

    public static void main(String[] args){
        minimumAbsoluteDifference(new int[] {5, 8, 4, 2, 9, 0});
        System.out.println("==========================");
        minimumAbsoluteDifference(new int[] {45, -89, 12, -62, 31, -57});
        System.out.println("==========================");
        minimumAbsoluteDifference(new int[] {5, -3, 7, -2});
    }
    public static void minimumAbsoluteDifference(int[] array){
        Arrays.sort(array);
        System.out.println("Input:"+Arrays.toString(array));
        Map<Integer,String> map= new TreeMap<>();
        int diff = 0;
        for(int i=0;i<array.length-1;i++){
             diff = array[i+1]-array[i];
             map.put(diff, "[" + array[i + 1] + "," + array[i] + "]");
        }
        Map.Entry<Integer,String> map1 = map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                        .findFirst().get();
         System.out.println(map1.getKey()+":"+map1.getValue());
    }
}
