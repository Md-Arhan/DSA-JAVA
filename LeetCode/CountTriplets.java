class Solution {
    public int specialTriplets(int[] nums) {
        int mod = 1_000_000_007;
        HashMap<Integer, Long> leftCount = new HashMap<>();
        HashMap<Integer, Long> rightCount = new HashMap<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            rightCount.put(nums[i], rightCount.getOrDefault(nums[i], 0L) +1);
        }

        long count = 0;

        for(int val : nums){
            int x = val;

            rightCount.put(x, rightCount.get(x) -1);

            int j = x * 2;

            long left = leftCount.getOrDefault(j, 0L);
            long right = rightCount.getOrDefault(j, 0L);

            count = (count + (left * right) % mod) % mod;

            leftCount.put(x, leftCount.getOrDefault(x, 0L) +1);
        }

        return (int)count;
    }
}