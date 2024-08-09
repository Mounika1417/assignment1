package datastructuresassignments;

public class StringManipulation {
    public static String manipulateStrings(String str1, String str2, int length) {
        // Concatenate the two strings
        String concatenated = str1 + str2;

        // Reverse the concatenated string
        String reversed = new StringBuilder(concatenated).reverse().toString();

        // Check if the required length is larger than the reversed string
        if (length >= reversed.length()) {
            return reversed; // Return the entire reversed string
        }

        // Calculate the starting index of the middle substring
        int startIndex = (reversed.length() - length) / 2;

        // Extract and return the middle substring of the specified length
        return reversed.substring(startIndex, startIndex + length);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(manipulateStrings("hello", "world", 3)); // Expected: "row"
        System.out.println(manipulateStrings("abc", "", 2));        // Expected: "cb"
        System.out.println(manipulateStrings("", "", 2));           // Expected: ""
        System.out.println(manipulateStrings("java", "program", 20)); // Expected: "margorpavaj"
    }
}
