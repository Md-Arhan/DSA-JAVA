package Greedy;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        if(nums.length == 1){
            return 0;
        }

        if(nums[start] > nums[1]){
            return start;
        }

        if(nums[end] > nums[end-1]){
            return end;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(mid > 0 && mid < nums.length){
                if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] ){
                    return mid;
                }else if(nums[mid-1] < nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                start++;
            }
        }

        return -1;
    }

    public int findPeakElementss(int[] nums) {
        int peak = 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[peak]) {
                peak = i;
            }
        }
        return peak;
    }


    public int findPeakElements(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        if(nums.length == 1){
            return 0;
        }

        if(nums[start] > nums[1]){
            return start;
        }

        if(nums[end] > nums[end-1]){
            return end;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(start > 0 && end < nums.length){
                if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] ){
                    return mid;
                }else if(nums[mid-1] < nums[mid]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }else{
                start++;
            }
        }

        return -1;
    }

}
