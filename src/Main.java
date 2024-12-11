//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // UC1: Simple LinkedList
        list.add(56);
        list.add(30);
        list.add(70);
        System.out.println("LinkedList after UC1:");
        list.printList();

        // UC2: Add elements to the beginning
        list.addFirst(15);
        System.out.println("LinkedList after UC2:");
        list.printList();
        // UC3: Append elements
        list.append(85);
        System.out.println("LinkedList after UC3:");
        list.printList();

        // UC4: Insert element in between
        list.insertAfter(30, 40);
        System.out.println("LinkedList after UC4:");
        list.printList();

        // UC5: Delete the first element
        list.pop();
        System.out.println("LinkedList after UC5:");
        list.printList();

        // UC6: Delete the last element
        list.popLast();
        System.out.println("LinkedList after UC6:");
        list.printList();

        // UC7: Search for a node
        System.out.println("Is 30 in the list? " + list.search(30));
    }
}

