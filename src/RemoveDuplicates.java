import java.util.*;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1, 4));

        Set<Integer> set = new HashSet<>(list);

        list = new ArrayList<>(set);

        System.out.println(list);
    }

}