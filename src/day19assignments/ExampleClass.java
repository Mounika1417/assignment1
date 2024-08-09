package day19assignments;
public class ExampleClass {
    private String privateField = "Initial Value";

    private void privateMethod() {
        System.out.println("Private method called.");
    }

    private ExampleClass() {
        System.out.println("Private constructor called.");
    }

    public String getPrivateField() {
        return privateField;
    }
}
