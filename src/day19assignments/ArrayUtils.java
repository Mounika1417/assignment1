package day19assignments;
public class ArrayUtils {

    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        // Check if indices are within bounds
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices");
        }
        
        // Swap elements
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        // Demonstrate with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer array: ");
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Swap elements
        swap(intArray, 1, 3);
        
        System.out.println("Integer array after swap: ");
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Demonstrate with String array
        String[] strArray = {"apple", "banana", "cherry"};
        System.out.println("Original String array: ");
        for (String s : strArray) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        // Swap elements
        swap(strArray, 0, 2);
        
        System.out.println("String array after swap: ");
        for (String s : strArray) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        // Demonstrate with Double array
        Double[] dblArray = {1.1, 2.2, 3.3};
        System.out.println("Original Double array: ");
        for (double d : dblArray) {
            System.out.print(d + " ");
        }
        System.out.println();
        
        // Swap elements
        swap(dblArray, 1, 2);
        
        System.out.println("Double array after swap: ");
        for (double d : dblArray) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
