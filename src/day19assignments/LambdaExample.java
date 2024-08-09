package day19assignments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Print the original list
        System.out.println("Original List:");
        for (Person person : people) {
            System.out.println(person);
        }

        // Sort the list by age using a lambda expression
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print the sorted list
        System.out.println("\nSorted List by Age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
