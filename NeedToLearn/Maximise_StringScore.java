package NeedToLearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Maximise_StringScore {
    class Solution {
        public int maxScore(String s, char[][] jumps) {
            int n = s.length();
            if (n == 0)
                return 0;

            long[] psums = new long[n + 1];
            for (int i = 0; i < n; i++) {
                psums[i + 1] = psums[i] + s.charAt(i);
            }

            Set<Character> unique = new HashSet<>();
            for (char c : s.toCharArray())
                unique.add(c);

            Map<Character, long[]> charPrefix = new HashMap<>();
            Map<Character, Integer> ordMap = new HashMap<>();

            for (char c : unique)
                ordMap.put(c, (int) c);

            for (char ch : unique) {
                long[] arr = new long[n + 1];
                for (int i = 0; i < n; i++) {
                    arr[i + 1] = arr[i] + (s.charAt(i) == ch ? 1 : 0);
                }
                charPrefix.put(ch, arr);
            }

            Map<Character, Set<Character>> jumpMap = new HashMap<>();
            for (char[] jp : jumps) {
                jumpMap.computeIfAbsent(jp[0], k -> new HashSet<>()).add(jp[1]);
            }

            long[] dp = new long[n + 1];
            Map<Character, Long> bestVal = new HashMap<>();
            for (char c : unique)
                bestVal.put(c, Long.MIN_VALUE);

            for (int pos = n - 1; pos >= 0; pos--) {
                char ch = s.charAt(pos);
                int chOrd = ordMap.get(ch);
                long maxScore = 0;

                Set<Character> charsToCheck = new HashSet<>();
                charsToCheck.add(ch);
                if (jumpMap.containsKey(ch))
                    charsToCheck.addAll(jumpMap.get(ch));

                long baseSum = psums[pos];

                for (char target : charsToCheck) {
                    long best = bestVal.getOrDefault(target, Long.MIN_VALUE);
                    if (best == Long.MIN_VALUE)
                        continue;

                    long[] prefArr = charPrefix.get(target);
                    long cnt = prefArr[pos];
                    long score = best + cnt * ordMap.get(target) - baseSum;
                    if (score > maxScore)
                        maxScore = score;
                }

                dp[pos] = maxScore;

                long[] arr = charPrefix.get(ch);
                long val = psums[pos + 1] + dp[pos] - arr[pos + 1] * chOrd;

                if (val > bestVal.get(ch))
                    bestVal.put(ch, val);
            }

            return (int) dp[0];
        }
    }
}


/*
🎯 Core Idea of the Problem

We move through the string and form segments.

At certain characters, we are allowed to:

jump to another character (based on rules in jumps)

when we jump → we earn a score

The score for a jump is:

the ASCII sum of the characters
inside the current segment
since the previous jump
and before the landing index

After a jump:

a new segment begins

scoring starts fresh from there

So the task is:

choose where to jump
so total collected segment-scores is maximum

This becomes an optimal segmentation problem.

💡 Why this is not greedy

Because:

jumping too early may waste a bigger future segment

skipping certain characters may produce a better segment later

So we must decide:

Should we jump here?
Or wait for a better jump later?

That’s why this is solved using Dynamic Programming.

🧠 Conceptual DP Meaning (No code — only idea)

Think backwards:

At each index:

“If I start a segment from here,
what is the maximum score I can get until the end?”

For each character:

sometimes extending the current segment is beneficial

sometimes jumping now gives more score

sometimes skipping and waiting is best

So we track:

the best score from the future onwards

for each character we may jump into

That is what your DP logic models.

🧩 What happens when we jump?

Suppose we jump at index i.

We score:

sum of ASCII of characters in current segment before i

Then:

segment resets

scoring restarts after i

So for every jump we combine:

score from current segment
+ best possible score from future segment


We always choose the max.

🟢 Why we track character-specific best values

Different characters have different:

ASCII weights

jump rules

frequency patterns

Sometimes it is better to:

continue a run of rs

sometimes jump to a future g

sometimes restart a new scoring segment

So for each character we store:

“if a future segment ends in this character,
what is the best score I could attach to it?”

Earlier you saw examples:

'r' gave more score because ASCII is higher

skipping g changed which characters were counted

This is why each character has its own best state.
 */