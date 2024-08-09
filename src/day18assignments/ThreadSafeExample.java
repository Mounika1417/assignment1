package day18assignments;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeExample {

    // Thread-Safe Counter Class
    public static class Counter {
        private final AtomicInteger count = new AtomicInteger(0);

        // Increment the counter
        public void increment() {
            count.incrementAndGet();
        }

        // Decrement the counter
        public void decrement() {
            count.decrementAndGet();
        }

        // Get the current count
        public int getCount() {
            return count.get();
        }
    }

    // Immutable Data Class
    public static final class ImmutableData {
        private final int data;

        // Constructor
        public ImmutableData(int data) {
            this.data = data;
        }

        // Getter for data
        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        // Create an instance of Counter
        Counter counter = new Counter();

        // Create and start threads that use the Counter
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());

        // Demonstrating ImmutableData usage
        ImmutableData immutableData = new ImmutableData(42);

        // Thread that uses immutable data
        Thread immutableDataThread = new Thread(() -> {
            System.out.println("Immutable data: " + immutableData.getData());
        });

        immutableDataThread.start();

        try {
            immutableDataThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
