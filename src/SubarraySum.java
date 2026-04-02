public class SubarraySum {

    public static void main(String[] args) {

        int[] arr = {12, 5, 31, 9, 21, 8};
        int target = 45;

        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {

            sum += arr[end];

            // shrink window if sum exceeds target
            while (sum > target && start < end) {
                sum -= arr[start];
                start++;
            }

            if (sum == target) {
                System.out.print("Subarray: ");
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                break;
            }
        }
    }
}