import java.util.Objects;

class MyHashMap<K, V> {

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> head;

    // PUT method
    public void put(K key, V value) {

        // Case 1: Empty map
        if (head == null) {
            head = new Node<K,V>(key, value);
            return;
        }

        Node<K, V> current = head;

        while (current != null) {

            // If key exists → update
            if (Objects.equals(current.key, key)) {
                current.value = value;
                return;
            }

            // If last node → insert
            if (current.next == null) {
                current.next = new Node<>(key, value);
                return;
            }

            current = current.next;
        }
    }

    // GET method
    public V get(K key) {
        Node<K, V> current = head;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null; // not found
    }
}

public class MainHashMap {
    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("NOE", 100);

        System.out.println(map.get("ONE")); // 1
        System.out.println(map.get("TWO")); // 2
        System.out.println(map.get("NOE")); // 100

        map.put("ONE", 10);
        System.out.println(map.get("ONE")); // 10
    }
}