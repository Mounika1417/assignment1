package datastructuresassignments;

public class JumpSearch {

    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int blockSize = (int) Math.sqrt(n); // Determine the block size

        // Finding the block where the target element might be present
        int step = blockSize;
        int prev = 0;
        while (step < n && arr[step] < target) {
            prev = step;
            step += blockSize;
        }

        // Perform linear search in the found block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int target1 = 30;
        int target2 = 35;

        // Perform Jump Search
        int index1 = jumpSearch(array, target1);
        int index2 = jumpSearch(array, target2);

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
