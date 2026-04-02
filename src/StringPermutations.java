public class StringPermutations {

    public static void main(String[] args) {
        String str = "JSP";
        permute(str.toCharArray(), 0);
    }

    static void permute(char[] arr, int index) {

        if (index == arr.length - 1) {
            System.out.println(String.valueOf(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i); // backtrack
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}