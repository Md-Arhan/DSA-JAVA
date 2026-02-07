import java.util.HashMap;

public class CntNoOfTrizones {
    class Solution {
    public int countTrapezoids(int[][] points) {
        long mod = 1_000_000_007;
        int n = points.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int y = points[i][1];

            map.put(y, map.getOrDefault(y, 0) +1);
        }

        long ans = 0;
        long prefix = 0;

        for(int val : map.values()){
            if(val < 2) continue;
            long comb = (long) val * (val - 1) / 2;

            ans = (ans + (comb * prefix)) % mod;

            prefix = (prefix + comb) % mod;
        }

        return (int)ans;
    }
}
}


// the formula for combinations n *  ( n-1 ) / 2;