public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        permutation(nums, 0);
        return nums;
    }

    public void permutation(int[] nums, int start){
       if(start < nums.length){
         int res = nums[nums[start]];
         permutation(nums, start+1);
         nums[start] = res;
       }
    }
}
