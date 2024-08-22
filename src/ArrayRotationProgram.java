
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayRotationProgram {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int rotation = 31;  // Number of positions to rotate left
        System.out.println("Input Array Before Rotation:");
        System.out.println(Arrays.toString(array));
        // Perform left rotation
        rotateLeft(array, rotation);

    }

    private static void rotateLeft(int[] array, int positions) {
        int n = array.length;
        // Normalize the rotation number in case it is greater than array length
       int effectiveRotation = positions % n;
        System.out.println(effectiveRotation);
        // Rotate the array
         List<Integer> list = IntStream.concat(
                        Arrays.stream(array, effectiveRotation, n),   // Elements from the rotation point to the end
                        Arrays.stream(array, 0, effectiveRotation)    // Elements from the start to the rotation point
                ).boxed().collect(Collectors.toList());// .forEach(array1->System.out.println(Arrays.toString(array1)));
        System.out.println(list);
     }
}
