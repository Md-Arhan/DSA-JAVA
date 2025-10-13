public class LargestLexographlcally {
    public String largestSwap(String s) {
        char[] alpha = s.toCharArray();
        int n = alpha.length;

        int[] index = new int[10];
        for (int i = 0; i < n; i++) {
            index[alpha[i] - '0'] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 9; j > alpha[i] - '0'; j--) {
                if (index[j] > i) {
                    char temp = alpha[i];
                    alpha[i] = (char)(j + '0');
                    alpha[index[j]] = temp;
                    return new String(alpha);
                }
            }
        }

        return s; 
    }
}


/*
 * Intuition in one line
For each digit from left to right, check if there is a larger digit to its right (rightmost occurrence). If yes, swap the leftmost smaller digit with the rightmost largest digit.
 */