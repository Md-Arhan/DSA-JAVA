public class MaximumNonOverlappingPalindrome {
    public int isPalindrome(String s, int i, int j, int[] lastEnd, int k) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (j - i + 1 >= k && i > lastEnd[0]) {
                lastEnd[0] = j;
                return 1;
            }
            i--;
            j++;
        }
        return 0;
    }

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] lastEnd = { -1 };
        int count = 0;

        for (int idx = 0; idx < n; idx++) {
            count += isPalindrome(s, idx, idx, lastEnd, k);
            count += isPalindrome(s, idx, idx + 1, lastEnd, k);
        }
        return count;
    }
}
