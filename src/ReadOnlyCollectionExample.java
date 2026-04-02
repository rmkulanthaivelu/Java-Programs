import java.util.*;

public class ReadOnlyCollectionExample {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Make list read-only
        List<String> readOnlyList = Collections.unmodifiableList(list);

        System.out.println("Read-only list: " + readOnlyList);

        // Attempting modification will throw UnsupportedOperationException
        try {
            readOnlyList.add("JavaScript");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify read-only list!");
        }
    }
}