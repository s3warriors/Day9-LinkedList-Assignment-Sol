class OrderedLinkedList<T extends Comparable<T>> {
    private Node<T> head;

    // Node class for internal representation
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to create an empty list
    public OrderedLinkedList() {
        this.head = null;
    }

    // Adds an item to the list maintaining order
    public void add(T item) {
        Node<T> newNode = new Node<>(item);

        if (head == null || head.data.compareTo(item) > 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && current.next.data.compareTo(item) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Removes an item from the list
    public void remove(T item) {
        if (head == null) return;

        if (head.data.equals(item)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Searches for an item in the list
    public boolean search(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) return true;
            current = current.next;
        }
        return false;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Returns the size of the list
    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Returns the index of the item in the list
    public int index(T item) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(item)) return index;
            index++;
            current = current.next;
        }
        return -1; // Item not found
    }

    // Removes and returns the last item in the list
    public T pop() {
        if (head == null) return null;

        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T data = current.next.data;
        current.next = null;
        return data;
    }

    // Prints the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OrderedLinkedList<Integer> list = new OrderedLinkedList<>();

        // Test the OrderedLinkedList API
        list.add(30);
        list.add(56);
        list.add(40);
        list.add(70);
        System.out.println("Ordered List after adding elements:");
        list.printList();

        System.out.println("Size of the list: " + list.size());

        list.remove(40);
        System.out.println("Ordered List after removing 40:");
        list.printList();

        System.out.println("Is 30 present in the list? " + list.search(30));
        System.out.println("Index of 70: " + list.index(70));

        System.out.println("Popped last element: " + list.pop());
        System.out.println("Ordered List after popping last element:");
        list.printList();

        System.out.println("Is the list empty? " + list.isEmpty());
    }
}
