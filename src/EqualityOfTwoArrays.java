import java.util.Arrays;

public class EqualityOfTwoArrays {
    public static void main(String args[]) {
        int[] arrayOne = {2, 5, 1, 7, 4};
        int[] arrayTwo = {2, 5, 1, 7, 5};
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        if(Arrays.equals(arrayOne,arrayTwo))
            System.out.println("True");
        else
            System.out.println("False");

    }
}
