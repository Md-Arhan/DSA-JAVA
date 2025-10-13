public class TwoPointersLexo {
     public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        String ans = "";
        int m = word.length();
        int mx_part_len = m - numFriends + 1;

        for (int i = 0; i < m; i++) {
            StringBuilder tmp = new StringBuilder();

            for (int j = i; j < Math.min(i + mx_part_len, m); j++) {
                tmp.append(word.charAt(j));
            }

            if (tmp.toString().compareTo(ans) > 0) {
                ans = tmp.toString();
            }
        }

        return ans;
    }
}



/*
 * Let's dry run your method answerString on input:

word = "gggg"

numFriends = 4

Step 1: Setup
numFriends == 4 → not 1, so proceed

ans = "" (empty string initially)

m = word.length() = 4

mx_part_len = m - numFriends + 1 = 4 - 4 + 1 = 1

So we're looking for substrings of length 1 (since mx_part_len = 1).

Step 2: Outer loop runs from i = 0 to i = 3 (since m = 4)
For each i, build a substring of length at most 1 (because of mx_part_len).

Iteration 1: i = 0
Inner loop: j from 0 to min(0 + 1, 4) = 1

tmp = ""

tmp.append(word.charAt(0)) → tmp = "g"

Compare "g" to ans = "": "g" > "" → update ans = "g"

Iteration 2: i = 1
Inner loop: j from 1 to min(1 + 1, 4) = 2

tmp = ""

tmp.append(word.charAt(1)) → tmp = "g"

Compare "g" to ans = "g": "g" == "g" → no change to ans

Iteration 3: i = 2
Inner loop: j from 2 to min(2 + 1, 4) = 3

tmp = ""

tmp.append(word.charAt(2)) → tmp = "g"

Compare "g" to ans = "g": no change

Iteration 4: i = 3
Inner loop: j from 3 to min(3 + 1, 4) = 4

tmp = ""

tmp.append(word.charAt(3)) → tmp = "g"

Compare "g" to ans = "g": no change


 */