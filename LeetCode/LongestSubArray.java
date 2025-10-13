import java.util.HashMap;

public int longestSubarray(int[] arr, int k) {
        // Code Here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = arr.length;
        int sum = 0;
        int ans = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] > k){
                sum++;
            }else{
                sum--;
            }
            
            if(sum > 0){
                ans=i+1;
            }else{
                map.putIfAbsent(sum, i);
                if(map.containsKey(sum-1)){
                    int idx = map.get(sum-1);
                    ans = Math.max(ans, i - idx);
                }
            }
        }
        
        return ans;
}
    


/*Exactly, you’ve got the right idea!
Let’s make it crystal clear:

Key principle in your algorithm:
You are tracking a prefix sum (sum) where:

+1 for elements > k

-1 for elements <= k

The goal: find the longest subarray where this running sum becomes positive.

How the hashmap helps:
When sum > 0 at index i:

It means from index 0 to i, there are already more elements > k than <= k.

So, the entire subarray [0…i] is valid.

When sum <= 0 at index i:

You need to find if there was an earlier index where (sum - 1) occurred.

Why?
If prefix[j] = sum - 1, then the subarray (j+1 ... i) will have more +1’s than -1’s (net sum positive).

This is why you do:

java
Copy
Edit
int idx = map.get(sum - 1);
ans = Math.max(ans, i - idx);
Answering your question:
so the longest is between the map.get(index) + 1 to curr index?

Yes.
More precisely:

When you find (sum - 1) in the map at some index idx,
the subarray from (idx + 1) to i is guaranteed to have more elements > k than <= k. 


Visual intuition
For [1, 2, 3, 4, 1], k = 2
Encoded: -1, -1, +1, +1, -1
Prefix sums: -1, -2, -1, 0, -1
At i = 3 (4th element):
sum = 0 (not > 0)
sum - 1 = -1 exists in the map at index 0
So subarray (1 to 3) has more +1 than -1 (2 vs 1)
Let’s visualize step by step why sum - 1 works with a number line idea.

Setup
Array: [1, 2, 3, 4, 1], k = 2
Encode:

>k  -> +1
<=k -> -1
Encoded: [-1, -1, +1, +1, -1]*/