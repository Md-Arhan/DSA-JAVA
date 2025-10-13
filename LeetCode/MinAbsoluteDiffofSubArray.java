import java.util.ArrayDeque;
import java.util.Deque;

public class MinAbsoluteDiffofSubArray {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int left = 0;
        int right;
        int maxLength = 0;

        for (right = 0; right < n; right++) {
        
            while(!maxD.isEmpty() && nums[right] > maxD.peekLast()){
                maxD.pollLast();
            }
            maxD.addLast(nums[right]);

            while(!minD.isEmpty() && nums[right] < minD.peekLast()){
                minD.pollLast();
            }
            minD.addLast(nums[right]);

            while(maxD.peekFirst() - minD.peekFirst() > limit){
                if (nums[left] == maxD.peekFirst()) {
                    maxD.pollFirst();
                }
                if (nums[left] == minD.peekFirst()) {
                    minD.pollFirst();
                }
                left++;
            }
            
            int length = right - left + 1;
            if(length > maxLength){
                maxLength = length;
            }

        }

        return maxLength;
    }
}
