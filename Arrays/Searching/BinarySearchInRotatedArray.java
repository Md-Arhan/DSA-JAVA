package Arrays.Searching;

public class BinarySearchInRotatedArray {
    int start = 0;
    int end = nums.length-1;

    while(start<=end)
    {
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else {
            if (target > nums[mid] && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    return-1;
}

class Solution {
    public int findMininDup(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while(low < high){

            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            else if(nums[mid] < nums[high]){
                high = mid;
            }
            else{
                high--;
            }
        }

        return nums[low];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int si = 0;
        int ei = n-1;

        while(si < ei){
            int mid = si + (ei - si) / 2;

            if(nums[mid] > nums[ei]){
                si = mid + 1;
            }else{
                ei = mid;
            }
        }

        return nums[si];
    }
}