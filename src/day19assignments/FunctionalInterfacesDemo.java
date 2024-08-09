package day19assignments;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {

    // Method that accepts a Predicate to test a Person
    public static void testPersonPredicate(Person person, Predicate<Person> predicate) {
        boolean result = predicate.test(person);
        System.out.println("Predicate test result: " + result);
    }

    // Method that accepts a Function to transform a Person
    public static void transformPerson(Person person, Function<Person, String> function) {
        String result = function.apply(person);
        System.out.println("Function result: " + result);
    }

    // Method that accepts a Consumer to perform an action on a Person
    public static void performAction(Person person, Consumer<Person> consumer) {
        consumer.accept(person);
    }

    // Method that accepts a Supplier to create a Person
    public static void createAndPrintPerson(Supplier<Person> supplier) {
        Person person = supplier.get();
        System.out.println("Created Person: " + person);
    }

    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30);

        // Test Predicate
        testPersonPredicate(person, p -> p.getAge() > 25);

        // Transform Person using Function
        transformPerson(person, p -> "Name: " + p.getName() + ", Age: " + p.getAge());

        // Perform action using Consumer
        performAction(person, p -> p.setAge(p.getAge() + 1));
        System.out.println("Person after Consumer action: " + person);

        // Create a new Person using Supplier
        createAndPrintPerson(() -> new Person("Bob", 25));
    }
}
