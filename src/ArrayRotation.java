import java.util.Arrays;

public class ArrayRotation {
   public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = 2; // positions to rotate

        int[] rotated = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rotated[i] = arr[(i + n) % arr.length];
        }

        System.out.println("Left Rotation: " + Arrays.toString(rotated));
    }
}