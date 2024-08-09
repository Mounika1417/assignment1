package datastructuresassignments;

//Node1 class for the linked list
class Node1 {
 Object data;
 Node1 next;

 public Node1(Object data) {
     this.data = data;
     this.next = null;
 }
}

//Queue class implementing a generic queue using a linked list
public class Queue {
 private Node1 front; // Front of the queue (head of the linked list)
 private Node1 rear;  // Rear of the queue (tail of the linked list)
 private int size;    // Size of the queue

 // Constructor to initialize an empty queue
 public Queue() {
     front = null;
     rear = null;
     size = 0;
 }

 // Method to add an element to the queue (enqueue operation)
 public void enqueue(Object element) {
     Node1 newNode = new Node1(element);
     if (isEmpty()) {
         front = newNode;
     } else {
         rear.next = newNode;
     }
     rear = newNode;
     size++;
 }

 // Method to remove an element from the queue (dequeue operation)
 public Object dequeue() {
     if (isEmpty()) {
         System.out.println("Queue is empty. Cannot dequeue.");
         return null; // or handle differently, e.g., return a specific value
     }
     Object data = front.data;
     front = front.next;
     if (front == null) {
         rear = null;
     }
     size--;
     return data;
 }

 // Method to peek at the front element of the queue
 public Object peek() {
     if (isEmpty()) {
         System.out.println("Queue is empty. Cannot peek.");
         return null; // or handle differently, e.g., return a specific value
     }
     return front.data;
 }

 // Method to check if the queue is empty
 public boolean isEmpty() {
     return size == 0;
 }

 // Method to get the size of the queue
 public int size() {
     return size;
 }

 public static void main(String[] args) {
     Queue queue = new Queue();

     queue.enqueue(10);
     queue.enqueue(20);
     queue.enqueue(30);

     System.out.println("Queue size: " + queue.size()); // Output: Queue size: 3

     System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

     System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 10
     System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 20

     System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

     System.out.println("Front element: " + queue.peek()); // Output: Front element: 30

     System.out.println("Queue size: " + queue.size()); // Output: Queue size: 1

     queue.dequeue();
     System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true

     // Attempting to dequeue from an empty queue
     System.out.println("Dequeue: " + queue.dequeue()); // Output: Queue is empty. Cannot dequeue.
 }
}
