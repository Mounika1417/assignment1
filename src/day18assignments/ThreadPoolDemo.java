package day18assignments;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ComplexCalculationTask implements Runnable {
    private final int taskId;

    public ComplexCalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        // Simulate complex calculation or I/O operation
        performComplexCalculation();
        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());
    }

    private void performComplexCalculation() {
        try {
            // Simulate a long-running task
            Thread.sleep((long) (Math.random() * 1000) + 500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        int numberOfTasks = 10;
        int poolSize = 3;

        // Create a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

        // Submit multiple tasks to the thread pool
        for (int i = 1; i <= numberOfTasks; i++) {
            executorService.submit(new ComplexCalculationTask(i));
        }

        // Shut down the executor service
        executorService.shutdown();
        try {
            // Wait for all tasks to complete
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("All tasks completed.");
    }
}
