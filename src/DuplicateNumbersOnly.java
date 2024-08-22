import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumbersOnly {

    public static void main(String[] args)
    {
        int[] inputArray = new int[] {111, 333, 555, 777, 333, 444, 555};
        System.out.println("======Duplicates Using Java 8 Streams======");
        findDuplicatesUsingJava8(inputArray);
    }
    public static void findDuplicatesUsingJava8(int[] arr){
        Set<Integer> setVal = new HashSet<>();
        for(int i:arr){
            if(!setVal.add(i)){
                System.out.println("Duplicate Value:"+i);
            }
        }
        Set<Integer> setValJava8 = new HashSet<>();
      Arrays.stream(arr).boxed()
                .filter(i->!setValJava8.add(i))
                .collect(Collectors.toSet()).forEach(i->System.out.println(i));

    }

}
