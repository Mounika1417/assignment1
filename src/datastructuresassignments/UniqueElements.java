package datastructuresassignments;

public class UniqueElements {

    // Function to find the two unique elements in an array
    public static int[] findUniqueElements(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;  // XOR all elements to get the XOR of the two unique elements
        }

        // Find the rightmost set bit in xor
        int setBit = xor & ~(xor - 1);

        int[] result = {0, 0};
        for (int num : nums) {
            if ((num & setBit) == 0) {
                result[0] ^= num;  // XOR of all elements with the rightmost set bit not set
            } else {
                result[1] ^= num;  // XOR of all elements with the rightmost set bit set
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4};
        int[] uniqueElements = findUniqueElements(nums);
        System.out.println("The two unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}
