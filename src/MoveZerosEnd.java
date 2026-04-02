public class MoveZerosEnd {

    public static void main(String[] args) {

        int[] arr = {14, 0, 5, 2, 0, 3, 0};

        int index = 0; // position for next non-zero

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        // fill remaining with zeros
        while (index < arr.length) {
            arr[index++] = 0;
        }

        // print
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}