import java.util.Arrays;

public class ArrayRotation {
   public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = 3; // positions to rotate
        int[] rotated = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rotated[i] = arr[(i + n) % arr.length];
            System.out.println("Left Rotation: " + (i + n) % arr.length);
        }
        System.out.println("Left Rotation: " + Arrays.toString(rotated));
        int[] arr1 = {3,9,4,6,1,8,2};
        int len = 0;
       int[] rotated1 = new int[arr1.length];
       for (int i=arr1.length-1 ; i >=0 ; i--) {
           rotated1[len] = arr1[i];
           len++;
          // System.out.println("Left Rotation: " + (i + n) % arr1.length);
       }
       System.out.println("Left Rotation: " + Arrays.toString(rotated1));
    }
}