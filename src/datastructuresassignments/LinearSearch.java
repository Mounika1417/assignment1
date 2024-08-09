package datastructuresassignments;

public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // If the current element equals the target, return its index
            if (arr[i] == target) {
                return i;
            }
        }
        // Target not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };
        int target1 = 30;
        int target2 = 35;

        // Perform linear search
        int index1 = linearSearch(array, target1);
        int index2 = linearSearch(array, target2);

        // Output results
        if (index1 != -1) {
            System.out.println(target1 + " found at index: " + index1); // Output: 30 found at index: 2
        } else {
            System.out.println(target1 + " not found in the array");
        }

        if (index2 != -1) {
            System.out.println(target2 + " found at index: " + index2); // Output: 35 not found in the array
        } else {
            System.out.println(target2 + " not found in the array");
        }
    }
}
