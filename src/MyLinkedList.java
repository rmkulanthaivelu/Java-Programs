public class MyLinkedList<T> {

    // Node class
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    // 1️⃣ Add at end
    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // 2️⃣ Add at beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // 3️⃣ Get element
    public T get(int index) {
        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }

        throw new IndexOutOfBoundsException("Index: " + index);
    }

    // 4️⃣ Remove element
    public void remove(T data) {
        if (head == null) return;

        // if head needs to be removed
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // 5️⃣ Print list
    public void printList() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }


}