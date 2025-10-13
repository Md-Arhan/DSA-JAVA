import java.util.HashSet;

public class BrokenLanguages {
    class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer> brokenUsers = new HashSet<>();

        for (int[] f : friendships) {
            int u = f[0] - 1;
            int v = f[1] - 1;

            boolean canTalk = false;
            for (int langU : languages[u]) {
                for (int langV : languages[v]) {
                    if (langU == langV) {
                        canTalk = true;
                        break;
                    }
                }
                if (canTalk)
                    break;
            }

            if (!canTalk) {
                brokenUsers.add(u);
                brokenUsers.add(v);
            }
        }

        int[] freq = new int[n + 1];
        for (int user : brokenUsers) {
            for (int lang : languages[user]) {
                freq[lang]++;
            }
        }

        // Step 3: best language to teach
        int maxKnown = 0;
        for (int lang = 1; lang <= n; lang++) {
            maxKnown = Math.max(maxKnown, freq[lang]);
        }

        return brokenUsers.size() - maxKnown;

    }
}
}


/*
 * Instead, we can count frequencies directly:

Collect all users in broken friendships (brokenUsers).

For each such user, mark the languages they know.

Build a frequency map:

freq[lang] = how many brokenUsers already know lang.

Then:

Answer = brokenUsers.size() - max(freq[lang]).

Because if we pick the language that the most broken users already know, we minimize the number we need to teach.
 */