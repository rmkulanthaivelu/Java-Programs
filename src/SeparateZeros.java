import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeparateZeros {

    public static void main(String[] args) {
        System.out.println("Left Value  Right Zero");
        SeparateZerosToRight(new int[]{12, 0, 7, 0, 8, 0, 3});
        SeparateZerosToRight(new int[]{0, 0, 3, 6, 8, 0, 3});
        SeparateZerosToRight(new int[]{2, 0, 7, 0, 8, 6, 0});
        System.out.println("Left Zero Right Values");
        SeparateZerosToLeft(new int[]{12, 0, 7, 0, 8, 0, 3});
        SeparateZerosToLeft(new int[]{0, 0, 3, 6, 8, 0, 3});
        SeparateZerosToLeft(new int[]{2, 0, 7, 0, 8, 6, 0});
    }

   public static void SeparateZerosToRight(int[] array ){
       System.out.println("Input:"+Arrays.toString(array));
        List<Integer> result = IntStream.concat(
                Arrays.stream(array).filter(num -> num != 0),  // Non-zero elements
                Arrays.stream(array).filter(num -> num == 0)   // Zero elements
        ).boxed().collect(Collectors.toList());
        // Print the result
        System.out.println("Output:"+result);
    }

    public static void SeparateZerosToLeft(int[] array ){
        System.out.println("Input:"+Arrays.toString(array));
        List<Integer> result = IntStream.concat(
                Arrays.stream(array).filter(num -> num == 0),  // Non-zero elements
                Arrays.stream(array).filter(num -> num != 0)   // Zero elements
        ).boxed().collect(Collectors.toList());
        // Print the result
        System.out.println("Output:"+result);
    }
}
