package Arrays.Searching;

public class BinarySearch {

    public static int BS(int n[], int target) {

        for (int left = 0, right = n.length - 1; left <= right;) {
            int mid = left + (right - left) / 2; // Prevents overflow

            if (n[mid] == target) {
                return mid;
            } else if (n[mid] < target) {
                left = mid + 1; // Move left pointer correctly
            } else {
                right = mid - 1; // Move right pointer correctly
            }
        }
        return -1;
    }

    public int RotatedArraySearch(int[] nums, int target) {
        /*
         * while(start != end) {
         * int mid = start + (end - start) / 2;
         * if(nums[mid] == target) {
         * return mid;
         * }
         * // Rest of the code...
         * }
         * This loop exits prematurely when start == end, missing the last possible
         * element.
         * For binary search, the last comparison is crucial since it often contains the
         * answer.
         */
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
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

        return -1;
    }

    public static int[] prefix(int num[]){
        int prefix[] = new int[num.length];
        prefix[0] = num[0];
        int max = Integer.MIN_VALUE;

        for(int i=1; i<num.length; i++){
            prefix[i] = prefix[i-1] + num[i];
            max = Math.max(prefix[i], max);
        }

        
        return prefix;
    }

    public static void bs() {
        int arr[] = { 10, 20, 30, 40, 50 };
        int low = 0, high = arr.length - 1;
        int target = 40;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                index = mid;
                break;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }

        }

        if (index != -1) {
            System.out.println("present " + index);
        } else {
            System.out.println("not present");
        }
    }

    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid++;
            } else {
                end = mid--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 10, 20, 30, 40, 50 };
        int key = 40;

        System.out.println("index for key is " + binarySearch(numbers, key));

        int arr[] = { 10, 20, 30, 40, 50 };
        int target = 40;

        System.out.println(binarySearch(arr, target));
    }
}
