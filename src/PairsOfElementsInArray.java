import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PairsOfElementsInArray {
    public static void main(String[] args) {
        int[] array = {4, 6, 5, -10, 8, 5, 20};
        int targetSum = 10;
        sumOfElementArrayTwoNumbers(array,targetSum);

         targetSum = 15;
       // sumOfElementArrayThreeNumbers(array,targetSum);
    }
    public static void sumOfElementArrayTwoNumbers(int[] array,int targetSum){
        // Create a list of pairs that sum to the target value
        List<String> pairs = IntStream.range(0, array.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, array.length)
                        .filter(j -> array[i] + array[j] == targetSum)
                        .mapToObj(j -> "("+ array[i] + ", " + array[j]+")"))
                .collect(Collectors.toList());
            System.out.println(pairs);

    }

   /* public static void sumOfElementArrayThreeNumbers(int[] array,int targetSum){
        // Create a list of pairs that sum to the target value
        List<List<Integer>> pairs = IntStream.range(0, array.length).boxed()
                .flatMap(i -> IntStream.range(i + 1, array.length)
                        .flatMap(j -> IntStream.range(j + 1, array.length)
                        .filter(k -> array[i] + array[j] + array[k]== targetSum).boxed()
                        .mapToObj(k-> Arrays.asList(array[i],array[j],array[k])))
                ).collect(Collectors.toList());
        System.out.println(pairs);
    }*/
}
