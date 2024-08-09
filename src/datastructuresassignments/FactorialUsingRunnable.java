package datastructuresassignments;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class FactorialUsingRunnable {
    public static void main(String[] args) {
        int number = 5; // Example number to calculate factorial

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                long factorial = 1;
                for (int i = 1; i <= number; i++) {
                    factorial *= i;
                }
                System.out.println("Factorial of " + number + " is : " + factorial);
            }
        });

        executorService.shutdown();
    }
}
