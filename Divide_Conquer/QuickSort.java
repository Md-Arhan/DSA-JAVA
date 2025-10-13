package Divide_Conquer;

public class QuickSort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quicSort(int arr[], int si, int ei) {

        // base case
        if (si >= ei) {
            return;
        }

        // pivot = last element

        // partition
        int partIdx = partition(arr, si, ei);
        quicSort(arr, si, partIdx - 1); // left part
        quicSort(arr, partIdx + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {

        int pivot = arr[ei];
        int i = si - 1; // to make place for elem smaller than pivot

        for (int j = si; j <= ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // i++;
        // int temp = pivot;
        // arr[ei] = arr[i];
        // arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 8, 9, 2, 5 };
        quicSort(arr, 0, arr.length - 1);
        print(arr);

    }
}


//Leet code

// Random rand = new Random();

//     public void quickSort(int nums[], int si, int ei) {
//         if (si >= ei) {
//             return;
//         }

//         int partIdx = partition(nums, si, ei);
//         quickSort(nums, si, partIdx - 1);
//         quickSort(nums, partIdx + 1, ei);
//     }

//     public void swap(int nums[], int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }

//     public int partition(int nums[], int si, int ei) {
//         // Pick a random pivot
//         int random = si + rand.nextInt(ei - si + 1);
//         swap(nums, random, ei); // Move pivot to end
//         int pivot = nums[ei];

//         int j = si; // Pointer for smaller elements

//         for (int i = si; i < ei; i++) { // Loop only till ei - 1
//             if (nums[i] <= pivot) {
//                 swap(nums, i, j);
//                 j++;
//             }
//         }

//         swap(nums, j, ei); // Place pivot in correct position
//         return j;
//     }

//     public int[] sortArray(int[] nums) {
//         quickSort(nums, 0, nums.length - 1);
//         return nums;
//     }