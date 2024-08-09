package datastructuresassignments;

public class KMPAlgorithm {
    
    // Method to implement KMP algorithm for pattern searching
    public static void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        // Create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[M];
        int j = 0; // index for pattern[]

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pattern, M, lps);

        int i = 0; // index for text[]
        int comparisons = 0;
        while (i < N) {
            comparisons++;
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        System.out.println("Total comparisons made: " + comparisons);
    }

    // Method to compute the longest prefix suffix (lps) array
    public static void computeLPSArray(String pattern, int M, int[] lps) {
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(pattern, text);
    }
}
