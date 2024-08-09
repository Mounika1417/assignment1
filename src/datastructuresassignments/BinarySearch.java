package datastructuresassignments;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } else { // If target is smaller, ignore right half
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50, 60, 70 };
        int target1 = 30;
        int target2 = 35;

        // Perform binary search
        int index1 = binarySearch(array, target1);
        int index2 = binarySearch(array, target2);

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
