package datastructuresassignments;

//Node class for the stack
class Node {
 int data;
 Node next;

 public Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//Stack class implementing a stack data structure
public class Stack {
 private Node top; // Top of the stack
 private int size; // Size of the stack

 // Constructor to initialize an empty stack
 public Stack() {
     top = null;
     size = 0;
 }

 // Method to push an element onto the stack
 public void push(int element) {
     Node newNode = new Node(element);
     newNode.next = top;
     top = newNode;
     size++;
 }

 // Method to pop the top element from the stack
 public int pop() {
     if (isEmpty()) {
         System.out.println("Stack is empty. Cannot pop.");
         return -1; // or handle differently, e.g., return a specific value
     }
     int data = top.data;
     top = top.next;
     size--;
     return data;
 }

 // Method to peek at the top element of the stack
 public int peek() {
     if (isEmpty()) {
         System.out.println("Stack is empty. Cannot peek.");
         return -1; // or handle differently, e.g., return a specific value
     }
     return top.data;
 }

 // Method to check if the stack is empty
 public boolean isEmpty() {
     return top == null;
 }

 // Method to get the size of the stack
 public int size() {
     return size;
 }

 public static void main(String[] args) {
     Stack stack = new Stack();

     stack.push(10);
     stack.push(20);
     stack.push(30);

     System.out.println("Top element: " + stack.peek()); // Output: Top element: 30

     System.out.println("Pop element: " + stack.pop()); // Output: Pop element: 30
     System.out.println("Pop element: " + stack.pop()); // Output: Pop element: 20

     stack.push(40);
     System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false

     System.out.println("Pop element: " + stack.pop()); // Output: Pop element: 40
     System.out.println("Pop element: " + stack.pop()); // Output: Pop element: 10

     System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true

     // Attempting to pop from an empty stack
     System.out.println("Pop element: " + stack.pop()); // Output: Stack is empty. Cannot pop.
 }
}

