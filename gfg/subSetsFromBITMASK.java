public class subSetsFromBITMASK {
    class Solution {
    
    public int countSubset(int[] arr, int k) {
        // code here
       int n = arr.length;
       int mid = n / 2;

       int[] left = Arrays.copyOfRange(arr, 0, mid);
       int[] right = Arrays.copyOfRange(arr, mid, n);

       HashMap<Long, Long> map = new HashMap<>();

       int m = right.length;
       for (int mask = 0; mask < (1 << m); mask++) {
           long sum = 0;
           for (int i = 0; i < m; i++) {
               if((mask & (1 << i)) != 0){
                  sum+=right[i];
                }
            }
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        long ans = 0;
        m = left.length;

        for (int mask = 0; mask < (1 << m); mask++) {
            long sum = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += left[i];
                }
            }

            long need = k - sum;
            ans += map.getOrDefault(need, 0L);
        }

        return (int)ans;
    }
}

}
