package datastructuresassignments;

public class BoyerMooreAlgorithm {

    // Function to find the last occurrence of a pattern in a given text
    public static int lastOccurrence(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        if (m == 0 || n == 0 || m > n) {
            return -1; // No match possible
        }

        int[] badChar = new int[256];

        // Initialize all occurrences as -1
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1;
        }

        // Fill the actual value of last occurrence of a character in the pattern
        for (int i = 0; i < m; i++) {
            badChar[pattern.charAt(i)] = i;
        }

        int s = 0; // s is shift of the pattern with respect to text
        int lastIndex = -1;

        while (s <= (n - m)) {
            int j = m - 1;

            // Keep reducing index j of pattern while characters of pattern and text are matching at this shift s
            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            // If the pattern is present at current shift, then the index is updated
            if (j < 0) {
                lastIndex = s;
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        int lastIndex = lastOccurrence(text, pattern);
        if (lastIndex != -1) {
            System.out.println("Last occurrence of pattern found at index " + lastIndex);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
