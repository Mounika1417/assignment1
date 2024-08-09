package day19assignments;
public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    // Constructor to initialize the pair
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    // Getter for the first element
    public T1 getFirst() {
        return first;
    }

    // Getter for the second element
    public T2 getSecond() {
        return second;
    }

    // Setter for the first element
    public void setFirst(T1 first) {
        this.first = first;
    }

    // Setter for the second element
    public void setSecond(T2 second) {
        this.second = second;
    }

    // Method to reverse the pair
    public Pair<T2, T1> reverse() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    // Main method to demonstrate the usage
    public static void main(String[] args) {
        // Create a Pair with Integer and String
        Pair<Integer, String> pair = new Pair<>(1, "one");

        // Print original pair
        System.out.println("Original Pair: " + pair);

        // Get reversed pair
        Pair<String, Integer> reversedPair = pair.reverse();

        // Print reversed pair
        System.out.println("Reversed Pair: " + reversedPair);
    }
}
