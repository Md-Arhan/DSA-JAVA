public class Subarrays_Sum_In_Range {
    class Solution {

    public int solve(int arr[], int x){
        int n = arr.length;
        int j = 0;
        int sum = ;
        int count = 0;
        
        for(int i=0; i<n; i++){
            sum+=arr[i];
            while(sum > x){
                sum -= arr[j++];
            }
            
            if(sum <= x){
                count+= (i - j + 1);
            }
        }
        
        return count;
    }

        public int countSubarray(int[] arr, int l, int r) {
            // code here
            return solve(arr, r) - solve(arr, l - 1);
        }
    }
}


/*
Step 1: Read the problem
Count the number of subarrays whose sum is between L and R.
Most people immediately think:
"I'll generate every subarray."
Start at every index
    End at every index
        Calculate sum

Time Complexity:
O(n²)
Too slow.
So ask yourself:
Can I avoid checking every subarray individually?
 */


/*
Suppose every subarray is a student.
For
arr = [1,2,1]
All subarrays are
Subarray	Sum
[1]     	1
[1,2]     	3
[1,2,1]	    4
[2]     	2
[2,1]	    3
[1]     	1

Now let's group them by their sums.

Sum = 1
--------
[1]
[1]

Sum = 2
--------
[2]

Sum = 3
--------
[1,2]
[2,1]

Sum = 4
--------
[1,2,1]




Step 3: Subtract

Imagine two circles.

sum ≤ 3

+-----------------------------------+
|                                   |
|  sum=1    sum=2      sum=3        |
| [1] [1]    [2]    [1,2] [2,1]     |
|                                   |
+-----------------------------------+

Now remove everything having

sum ≤ 1

Those are

[1]
[1]

After removing them, only these remain:

[2]
[1,2]
[2,1]

Exactly the subarrays whose sums are between 2 and 3.
*/



/*
Suppose I ask:

How many numbers are between 5 and 10?

The numbers are

5 6 7 8 9 10

Now instead of counting them directly, think like this.

Count all numbers ≤ 10
1 2 3 4 5 6 7 8 9 10

There are 10.

Remove all numbers ≤ 4
1 2 3 4

What's left?

5 6 7 8 9 10

Exactly what we wanted.

Notice we removed ≤ 4, not ≤ 5.

Why?

Because 5 is part of the answer.

If we removed ≤ 5, we'd also remove 5.
*/