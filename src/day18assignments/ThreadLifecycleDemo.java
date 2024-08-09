package day18assignments;
public class ThreadLifecycleDemo {
    
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // RUNNABLE state
                    System.out.println("Thread state: " + Thread.currentThread().getState());

                    // SLEEP (TIMED_WAITING state)
                    Thread.sleep(1000);
                    System.out.println("Thread state after sleep: " + Thread.currentThread().getState());

                    // WAITING state
                    synchronized (lock) {
                        lock.wait();
                    }
                    System.out.println("Thread state after wait: " + Thread.currentThread().getState());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // TERMINATED state after run() method finishes
                System.out.println("Thread state: " + Thread.currentThread().getState());
            }
        });

        // NEW state
        System.out.println("Thread state: " + thread.getState());

        // Start the thread (RUNNABLE state)
        thread.start();
        System.out.println("Thread state after start: " + thread.getState());

        // Simulate BLOCKED state
        new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // Hold the lock for 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Ensure the first thread tries to enter WAITING state
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notify(); // Notify the waiting thread
        }

        // Ensure thread enters TERMINATED state
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state after join: " + thread.getState());
    }
}
