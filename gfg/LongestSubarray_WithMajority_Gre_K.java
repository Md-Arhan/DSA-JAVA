class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        
        int ans = 0;
        
        for(int i = 0; i<n; i++){
            if(arr[i] > k){
                sum++;
            }else{
                sum--;
            }
            
            if(sum > 0){
                ans = (i+1);
            }else{
                if(map.containsKey(sum-1)){
                    ans = Math.max(ans, i - map.get(sum-1));
                }
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        
        return ans;
    }
}


/*
Problem Intuition (Simple & Brief)

We want the longest subarray where median > k.

🔁 Step 1: Convert the Array

Turn the problem into something easier:

If arr[i] > k → treat it as +1

If arr[i] <= k → treat it as -1

Now the problem becomes:

Find the longest subarray whose sum > 0

Because:

More +1 than -1

Means more elements greater than k

Means median > k

🔁 Step 2: Use Prefix Sum

Keep a running sum.

If sum > 0 → whole prefix (0 to i) is valid

If sum <= 0 → check if we have seen sum - 1 before
(that guarantees a positive subarray)

Store first occurrence of each prefix sum in a HashMap.






Why Do We Check sum - 1?

Because prefix values change only by ±1.

At every step:

sum += 1   (if arr[i] > k)
sum -= 1   (if arr[i] <= k)

So prefix sums move like:

0 → 1 → 0 → -1 → 0 → 1 → ...

They change one step at a time.

🧠 Key Insight

If there exists any prefix smaller than sum,
the first time we reached sum - 1 is enough.

Why?

If some earlier prefix was:

sum - 2

Then before reaching sum - 2,
we must have passed through sum - 1.

Because we move only by ±1.

So:

If sum - 2 exists,
sum - 1 must have existed earlier.

And sum - 1 will always give a longer span
because it occurs earlier.




Because prefix changes only by ±1:

The earliest strictly smaller prefix

Must be sum - 1

And it always appears before any smaller value

Therefore it gives the longest valid subarray   */