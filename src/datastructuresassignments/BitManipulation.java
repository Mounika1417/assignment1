package datastructuresassignments;

public class BitManipulation {

    // Function to count the number of set bits in an integer
    public static int countSetBits(int x) {
        int count = 0;
        while (x > 0) {
            x &= (x - 1);  // Flip the least significant set bit
            count++;
        }
        return count;
    }

    // Function to count the total number of set bits in all integers from 1 to n
    public static int totalSetBits(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += countSetBits(i);
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 10;  // Example value
        System.out.println("Total number of set bits from 1 to " + n + " is: " + totalSetBits(n));
    }
}
