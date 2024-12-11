class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    // UC1: Create a simple linked list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // UC2: Add elements to the beginning of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // UC3: Append elements to the list
    public void append(T data) {
        add(data);
    }

    // UC4: Insert element in between
    public void insertAfter(T key, T data) {
        Node<T> temp = head;
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }
        if (temp != null) {
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    // UC5: Delete the first element
    public T pop() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        return data;
    }
    // UC6: Delete the last element
    public T popLast() {
        if (head == null) return null;
        if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        T data = temp.next.data;
        temp.next = null;
        return data;
    }
    // UC7: Search for a node
    public boolean search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) return true;
            temp = temp.next;
        }
        return false;
    }

    // UC8: Insert after searching
    public void insertAfterSearch(T key, T data) {
        if (search(key)) {
            insertAfter(key, data);
        }
    }


    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}