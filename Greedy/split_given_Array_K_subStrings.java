package Greedy;

/*Note:
*For large arrays, this recursive solution can be inefficient.
*To handle larger inputs, consider implementing a
*binary search + greedy approach as shown in the previous response. */


public class split_given_Array_K_subStrings {
    public static int ans = Integer.MAX_VALUE;

    public static void solve(int a[], int n, int k, int index, int sum, int maxsum) {
        // Base case: If only one subarray is left
        if (k == 1) {
            sum = 0;
            for (int i = index; i < n; i++) {
                sum += a[i];
            }
            maxsum = Math.max(maxsum, sum);
            ans = Math.min(ans, maxsum);
            return;
        }

        // Recursive case: Try different splits
        sum = 0;
        for (int i = index; i < n; i++) {
            sum += a[i];
            maxsum = Math.max(maxsum, sum);
            solve(a, n, k - 1, i + 1, sum, maxsum);
        }


    }

    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        ans = Integer.MAX_VALUE; // Reset the global answer
        solve(nums, n, k, 0, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};
        int k = 3;
        System.out.println(splitArray(arr, k));
    }
}




// public class Assignment {

//     public static boolean canSplit(int[] arr, int n, int k, int mid) {
//         int subarrayCount = 1;  // Start with one subarray
//         int currentSum = 0;

//         for (int i = 0; i < n; i++) {
//             // If adding this element exceeds the mid value, start a new subarray
//             if (currentSum + arr[i] > mid) {
//                 subarrayCount++;
//                 currentSum = arr[i];
//                 // If the number of subarrays exceeds k, it's not possible
//                 if (subarrayCount > k) {
//                     return false;
//                 }
//             } else {
//                 currentSum += arr[i];
//             }
//         }
//         return true;
//     }

//     // Function to find the minimum possible maximum subarray sum
//     public static int splitSubArrays(int[] arr, int n, int k) {
           /*❌ Why can't left = min(arr)?
            Because if you start from the smallest book (min value), you are assuming the maximum pages per student could be as low as that smallest book.
            But this will always fail if there’s a larger book than mid. 
            */
            
//         int left = 0, right = 0;
//         // Set left as the largest element, right as the sum of all elements
//         for (int i = 0; i < n; i++) {
//             left = Math.max(left, arr[i]);
//             right += arr[i];
//         }

//         // Binary search to find the minimum possible max subarray sum
//         int result = right;
//         while (left <= right) {
//             int mid = left + (right - left) / 2;
//             if (canSplit(arr, n, k, mid)) {
//                 result = mid;
//                 right = mid - 1;
//             } else {
//                 left = mid + 1;
//             }
//         }

//         return result;
//     }

//     public static void main(String[] args) {
//         int arr[] = {1, 2, 3, 4};
//         int n = arr.length;
//         int k = 2;
//         System.out.println(splitSubArrays(arr, n, k));  // Output: 5
//     }
// }



/*
 * Possible ways to split:
{1} {1,2}

Subarray sums = [1, 3]

Maximum sum = 3

{1,1} {2}

Subarray sums = [2, 2]

Maximum sum = 2

👉 Option 2 is better because max sum = 2 (smaller than 3).
 */


 /*
  * Dry-run of solve(arr, 3, 2, 0, 0, 0)
We loop i from 0 to 2:

➡️ First, i = 0:
sum += a[0] = 1

sum = 1

maxsum = max(0, 1) = 1

Recurse: solve(arr, 3, 1, 1, 1, 1)

🎯 Inside solve(arr, 3, 1, 1, 1, 1):
Since k == 1, base case.

Sum remaining elements from index 1 to 2:

a[1] + a[2] = 1 + 2 = 3

maxsum = max(1, 3) = 3

Update ans = min(Integer.MAX_VALUE, 3) = 3

Return.

➡️ Second, i = 1:
Back to previous call solve(arr, 3, 2, 0, 0, 0)

Now:

sum += a[1] = 1

sum = 1 + 1 = 2

maxsum = max(0, 2) = 2

Recurse: solve(arr, 3, 1, 2, 2, 2)

🎯 Inside solve(arr, 3, 1, 2, 2, 2):
Since k == 1, base case.

Sum remaining elements from index 2 to 2:

a[2] = 2

maxsum = max(2, 2) = 2

Update ans = min(3, 2) = 2

Return.

➡️ Third, i = 2:
sum += a[2] = 2

sum = 1+1+2 = 4

maxsum = max(0, 4) = 4

Recurse: solve(arr, 3, 1, 3, 4, 4)

🎯 Inside solve(arr, 3, 1, 3, 4, 4):
k == 1

No elements left to add.

sum = 0

maxsum = max(4, 0) = 4

Update ans = min(2, 4) = 2 (no change)

*/





  /*
   *  When only 1 subarray is left, we don't recurse anymore.
🔵 We directly collect all remaining elements into the last subarray.

   */






/*
* 
🔵 First call: solve(arr, 4, 2, 0, 0, 0)
n = 4

k = 2

index = 0

sum = 0

maxsum = 0

Loop over i = 0 to 3.

➡️ i = 0:
sum += arr[0] = 1

sum = 1

maxsum = max(0,1) = 1

Recurse: solve(arr, 4, 1, 1, 1, 1)

🔵 Second call: solve(arr, 4, 1, 1, 1, 1)
k == 1 → base case: put all remaining elements into one subarray.

Sum remaining elements: arr[1] + arr[2] + arr[3] = 2 + 3 + 4 = 9

New maxsum = max(1,9) = 9

Update: ans = min(INF, 9) = 9

Return.

Back to first call.

➡️ i = 1:
sum += arr[1] = 2

sum = 1 + 2 = 3

maxsum = max(0,3) = 3

Recurse: solve(arr, 4, 1, 2, 3, 3)

🔵 Second call: solve(arr, 4, 1, 2, 3, 3)
k == 1, base case.

Sum remaining elements: arr[2] + arr[3] = 3 + 4 = 7

New maxsum = max(3,7) = 7

Update: ans = min(9,7) = 7

Return.

Back to first call.

➡️ i = 2:
sum += arr[2] = 3

sum = 1 + 2 + 3 = 6

maxsum = max(0,6) = 6

Recurse: solve(arr, 4, 1, 3, 6, 6)

🔵 Second call: solve(arr, 4, 1, 3, 6, 6)
k == 1, base case.

Sum remaining elements: arr[3] = 4

New maxsum = max(6,4) = 6

Update: ans = min(7,6) = 6

Return.

➡️ i = 3:
sum += arr[3] = 4

sum = 1 + 2 + 3 + 4 = 10

maxsum = max(0,10) = 10

Recurse: solve(arr, 4, 1, 4, 10, 10)

🔵 Second call: solve(arr, 4, 1, 4, 10, 10)
No elements left.

New maxsum = max(10,0) = 10

Update: ans = min(6,10) = 6

Return.
    */