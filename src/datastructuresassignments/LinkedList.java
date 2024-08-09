package datastructuresassignments;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    // Node inner class
    private static class Node {
        private Object data;
        private Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add element to the end of the list
    public void add(Object data) {
        Node newNode = new Node(data);
        if (tail == null) {  // List is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove element by index
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        Node previous = null;

        if (index == 0) { // Removing the head
            head = current.next;
            if (head == null) { // List becomes empty
                tail = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
            if (current.next == null) { // Removing the tail
                tail = previous;
            }
        }

        size--;
        return current.data;
    }

    // Retrieve element by index
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Display all elements in the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.display(); // Output: First -> Second -> Third -> null

        System.out.println("Element at index 1: " + list.get(1)); // Output: Second

        list.remove(1);
        list.display(); // Output: First -> Third -> null

        System.out.println("Size of the list: " + list.size()); // Output: 2
    }
}
