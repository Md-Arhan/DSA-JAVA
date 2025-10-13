public class MaxSubarray {
    //Approach 1
    public static boolean can(int have[], int need[]) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < need[i]) {
                return false;
            }
        }

        return true;
    }

    public static String smallestWindow(String s, String p) {
        // code here
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int n = s.length();
        int m = p.length();

        int freq[] = new int[256];

        for (int i = 0; i < m; i++) {
            freq[p.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            int have[] = new int[256];

            for (int j = i; j < n; j++) {
                have[s.charAt(j)]++;

                if (can(have, freq)) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        minStart = i;
                    }
                    break;
                }
            }
        }

        return (minStart == -1) ? "" : s.substring(minStart, minStart + minLength);
    }

    // Approach 2
    public static String smallestWindow(String s, String p) {
        // code here
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int n = s.length();
        int m = p.length();

        int freq[] = new int[256];

        for (int i = 0; i < m; i++) {
            freq[p.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            int[] have = new int[256];
            int matched = 0;

            for (int j = i; j < n; j++) {
                char c = s.charAt(j);

                if (have[c] < freq[c]) {
                    matched++;
                }
                have[c]++;

                if (matched == m) { // all chars from p are included
                    int len = j - i + 1;
                    if (len < minLength) {
                        minLength = len;
                        minStart = i;
                    }
                    break;
                }
            }

        }

        return (minStart == -1) ? "" : s.substring(minStart, minStart + minLength);
    }

    //Approach 3
    
}
