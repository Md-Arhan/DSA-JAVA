class Solution {

    public String chooseSwap(String s) {

        int n = s.length();

        int[] freq = new int[26];

        Arrays.fill(freq, -1);

        

        // Track the first appearance index of each character

        for (int i = 0; i < n; i++) {

            if (freq[s.charAt(i) - 'a'] == -1) {

                freq[s.charAt(i) - 'a'] = i;

            }

        }

        

        for (int i = 0; i < n; i++) {

            int cur = s.charAt(i) - 'a';

            for (int ch = 0; ch < cur; ch++) {

                // If a lexicographically smaller character appears later in the string

                if (freq[ch] > i) {

                    char c1 = s.charAt(i);

                    char c2 = (char) (ch + 'a');

                    

                    // Convert to char array to perform a valid, permanent swap

                    char[] arr = s.toCharArray();

                    for (int j = 0; j < n; j++) {

                        if (arr[j] == c1) 

                            arr[j] = c2;

                         else if (arr[j] == c2) 

                            arr[j] = c1;

                        

                    }

                    // Return the newly constructed swapped string

                    return new String(arr);

                }

            }

        } 

        return s;

    }

}