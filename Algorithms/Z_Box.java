package Algorithms;

import java.util.ArrayList;

public class Z_Box {
    static ArrayList<Integer> zFunction(String s) {
        int n = s.length();
        ArrayList<Integer> z = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            z.add(0);
        }
        int l = 0, r = 0;
        
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                int k = i - l;
                
                // Case 2: reuse the previously computed value
                z.set(i, Math.min(r - i + 1, z.get(k)));
            }
            
            // Try to extend the Z-box beyond r
            while (i + z.get(i) < n && 
                    s.charAt(z.get(i)) == s.charAt(i + z.get(i))) {
                z.set(i, z.get(i) + 1);
            }
            
            // Update the [l, r] window if extended
            if (i + z.get(i) - 1 > r) {
                l = i;
                r = i + z.get(i) - 1;
            }
        }
        
        return z;
    }
}



/*
Z-ALGORITHM NOTES - The intuition: for every position i, find how many characters from i match the string’s prefix—while reusing matches already discovered.

z[i]:
Length of the longest prefix of s that matches the substring starting at i.

Z-box [l, r]:
A substring that matches the prefix.

s[l...r] == s[0...r-l]

For each i from 1 to n-1:

1. If i > r
   - i is outside the Z-box.
   - Start matching from scratch using the while loop.

2. If i <= r
   - i is inside the Z-box.
   - Find corresponding prefix position:
       k = i - l
   - Reuse a guaranteed match:
       z[i] = min(r - i + 1, z[k])

Why min?
   - z[k] = known match at corresponding prefix position.
   - r - i + 1 = characters remaining inside the Z-box.
   - Only matches inside the current Z-box are guaranteed.

3. Extend the match:
   while (i + z[i] < n &&
          s[z[i]] == s[i + z[i]]) {
       z[i]++;
   }

   Compare:
   - s[z[i]]       : next prefix character
   - s[i + z[i]]   : next substring character

4. Update Z-box if the current match goes farther:
   if (i + z[i] - 1 > r) {
       l = i;
       r = i + z[i] - 1;
   }

Memory trick:
Outside box → calculate fresh.
Inside box  → reuse z[k], limited by box boundary.
Beyond box  → extend using while loop.

Time complexity: O(n)
Space complexity: O(n)
*/