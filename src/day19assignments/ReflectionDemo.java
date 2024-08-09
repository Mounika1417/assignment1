package day19assignments;
import java.lang.reflect.Constructor;
import day19assignments.ExampleClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Load the ExampleClass
            Class<?> clazz = Class.forName("day19assignments.ExampleClass");

            // Inspect constructors
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Create an instance of ExampleClass using the private constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true); // Allow access to the private constructor
            Object instance = constructor.newInstance();

            // Inspect methods
            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("\nMethods:");
            for (Method method : methods) {
                System.out.println(method);
            }

            // Invoke the private method
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true); // Allow access to the private method
            privateMethod.invoke(instance);

            // Inspect fields
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nFields:");
            for (Field field : fields) {
                System.out.println(field);
            }

            // Access and modify the private field
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true); // Allow access to the private field
            System.out.println("\nOriginal private field value: " + privateField.get(instance));
            
            // Modify the private field's value
            privateField.set(instance, "Modified Value");
            System.out.println("Modified private field value: " + privateField.get(instance));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
