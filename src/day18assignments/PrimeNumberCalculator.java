package day18assignments;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeNumberCalculator {

    public static void main(String[] args) {
        int maxNumber = 100;
        int poolSize = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

       
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < poolSize; i++) {
            int start = (i * maxNumber / poolSize) + 1;
            int end = ((i + 1) * maxNumber / poolSize);
            futures.add(CompletableFuture.supplyAsync(() -> findPrimesInRange(start, end), executorService));
        }

       
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        CompletableFuture<List<Integer>> allPrimes = allOf.thenApply(v -> {
            List<Integer> combinedList = new ArrayList<>();
            for (CompletableFuture<List<Integer>> future : futures) {
                combinedList.addAll(future.join());
            }
            return combinedList;
        });


        allPrimes.thenAcceptAsync(primes -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\preet\\OneDrive\\Desktop\\JAVA-FSD-TRAINING\\primes.txt"))) {
                for (int prime : primes) {
                    writer.write(prime + "\n");
                }
                System.out.println("Prime numbers written to primes.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executorService);

       
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> findPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
