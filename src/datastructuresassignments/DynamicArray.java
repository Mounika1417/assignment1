package datastructuresassignments;

import java.util.Arrays;

public class DynamicArray {
    private int[] array;
    private int size; // Number of elements in the array
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the dynamic array with an initial capacity
    public DynamicArray() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // Method to add an element to the dynamic array
    public void add(int element) {
        ensureCapacity(size + 1);
        array[size++] = element;
    }

    // Method to insert an element at a specific index
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds.");
            return;
        }
        ensureCapacity(size + 1);
        // Shift elements to the right to make space for the new element
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    // Method to remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds.");
            return;
        }
        // Shift elements to the left to fill the gap
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = 0; // Optional: Set the last element to 0 or null
        size--;
    }

    // Method to update an element at a specific index
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds.");
            return;
        }
        array[index] = element;
    }

    // Method to get an element at a specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds.");
            return -1; // Or throw an exception or handle differently
        }
        return array[index];
    }

    // Method to get the size of the dynamic array
    public int size() {
        return size;
    }

    // Ensure the array has enough capacity
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    // Method to print the elements of the dynamic array
    public void print() {
        System.out.print("DynamicArray: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();

        da.add(10);
        da.add(20);
        da.add(30);
        da.print(); // Output: DynamicArray: 10 20 30

        da.insert(1, 15);
        da.print(); // Output: DynamicArray: 10 15 20 30

        da.remove(2);
        da.print(); // Output: DynamicArray: 10 15 30

        da.set(0, 5);
        da.print(); // Output: DynamicArray: 5 15 30

        System.out.println("Element at index 1: " + da.get(1)); // Output: Element at index 1: 15
        System.out.println("Size of dynamic array: " + da.size()); // Output: Size of dynamic array: 3
    }
}
