import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GCIProgrames {
    public static void main(String[] args) {
        listMerge();
        targetSum();
    }
    public static void targetSum() {
        int[] nums = { 7, 11, 15,2,3,6,4};
        int target = 10;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i+1; j <= nums.length-1; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(nums[i] + ":" + nums[j]);
                    System.out.println("Index is "+i + ":" + j);
                }
            }
        }
    }
    public static void listMerge() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);

        list2.add(1);
        list2.add(3);
        list2.add(4);

        list3.add(2);
        list3.add(6);
        list3.addAll(list1);
        list3.addAll(list2);
        Collections.sort(list3);
        System.out.println(list3);
    }
}
