package datastructuresassignments;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();
        
        // Start the Tower of Hanoi solution
        towerOfHanoi(n, 'A', 'B', 'C');
        
        scanner.close();
    }

    // Recursive function to solve Tower of Hanoi puzzle
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
}
