package day18assignments;
import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private final int MAX_SIZE = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (queue.size() == MAX_SIZE) {
                    System.out.println("Queue is full. Producer is waiting...");
                    wait();
                }
                System.out.println("Produced: " + value);
                queue.add(value++);
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (true) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty. Consumer is waiting...");
                    wait();
                }
                int consumedValue = queue.poll();
                System.out.println("Consumed: " + consumedValue);
                notify();
                Thread.sleep(500);
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
