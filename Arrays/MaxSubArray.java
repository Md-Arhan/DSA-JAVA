package Arrays;

public class MaxSubArray {

    public static void subArrays() {
        int arr[] = { 10, 20, 30, 40, 50 };
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void subArrays(int numbers[]) {
        int ts = 0;
        for (int i = 0; i < numbers.length; i++) {
            // System.out.print(numbers[i]+" ");
            int start = i;
            System.out.println();
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    System.out.print(numbers[k] + " ");
                    ts++;
                    sum = sum + numbers[k];
                }
                System.out.print(" = " + sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(ts);
    }

    public static void maxSubArray(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            // System.out.print(numbers[i]+" ");
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                int sum = 0;
                for (int k = start; k <= end; k++) {
                    sum = sum + numbers[k];
                }
                System.out.println(sum);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println(maxSum);
    }

    public static void prefixSubArray(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        int currSum = 0;

        prefix[0] = numbers[0];

        for (int i = 1; i < prefix.length; i++) {

            prefix[i] = prefix[i - 1] + numbers[i];
            System.out.println(prefix[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }

    public static void kadanesSubArray(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < numbers.length; i++) {

            currSum = currSum + numbers[i];
            // if(currSum < 0){
            // currSum = 0;
            // }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println(maxSum);

    }

    import java.util.TreeSet;

public int kadens(int[] arr, int n, int k) {
    TreeSet<Integer> prefixSums = new TreeSet<>();
    prefixSums.add(0);

    int currSum = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
        currSum += arr[i];

        // Find the smallest prefix ≥ currSum - k
        Integer prefix = prefixSums.ceiling(currSum - k);

        if (prefix != null) {
            max = Math.max(max, currSum - prefix);
        }

        prefixSums.add(currSum);
    }

    /*✅ Goal:
Find maximum sum of any contiguous subarray such that the sum is less than or equal to k.
🔍 Key Concepts:
currSum = prefix sum from index 0 to i.

For each index i, you're looking for a previous prefix sum (prefix) such that:
currSum - prefix ≤ k → prefix ≥ currSum - k
This forms a valid subarray sum.

So, you use:
TreeSet.ceiling(currSum - k)
to get the smallest prefix sum prefix such that the difference is still ≤ k.

🧠 Why it works:
You're storing all prefixSum[j] in the TreeSet.
Then at each position i, currSum - prefixSum[j] gives a contiguous subarray sum from j+1 to i. */

    return max;
}


    public static void main(String[] args) {
        // int number[] = { 2, 4, 6, 8, 10 };
        // subArrays(number);

        // int num[] = {2, 4, -1, 3, -2};
        // maxSubArray(number);
        // int num[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int numb[] = { -1, -2, -3, -4 }; // -1
        // // prefixSubArray(num);
        kadanesSubArray(numb);
    }
}
