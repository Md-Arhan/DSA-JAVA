package Arrays.Algorithms;

public class NaivePatternAlgorithm {
    //best Case : O(n)  Worst Case : O(n^2)
    public static class PatternSearch {

        public static void search(String pat, String txt) {
            int M = pat.length();  //"AABA"
            int N = txt.length();  // "AABAACAADAABAABA"
    
            // A loop to slide pat[] one by one
            for (int i = 0; i <= N - M; i++) {
                int j;
    
                // For current index i, check for pattern match
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
    
                // If pattern matches at index i
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
        }
    
        public static void main(String[] args) {
            // Example 1
            String txt1 = "AABAACAADAABAABA";
            String pat1 = "AABA";
            System.out.println("Example 1:");
            search(pat1, txt1);
    
            // Example 2
            String txt2 = "agd";
            String pat2 = "g";
            System.out.println("\nExample 2:");
            search(pat2, txt2);
        }
    }
}
