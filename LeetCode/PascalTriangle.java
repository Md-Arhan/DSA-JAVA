import java.util.HashMap;

public class PascalTriangle {
    public int calculate(String s){
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        
        return count;
    }
    
    public int countBalanced(String[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int ans = 0;
        int n = arr.length;
        int sum = 0;
        
        for(int i=0; i<n; i++){
            int freq = calculate(arr[i]);
            int vowels = freq;
            int consonants = arr[i].length() - freq;
            sum += (vowels - consonants);
            
            ans+=map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return ans;
    }
}


/*
 * What the question conceptually asks you to do
“Go through every subarray, add values inside it, and check if the total is balanced.”

That’s the brute-force way:
For every i..j, compute the sum.

What the optimized approach (prefix sum + map) actually does
Instead of literally adding every subarray:
Maintain a running total (prefix sum).

For the current total, we ask:

Has there been a previous total (prefix) such that 
current_sum - previous_sum = k?
For balanced subarrays, k = 0.
Subtraction lets us instantly know how many subarrays ending here are valid without recomputing sums.
Why this is “subtraction instead of addition”
In brute force, you explicitly add elements for every subarray.
With prefix sums, you rely on previous sums (stored in a map) and just subtract:
subarray sum = prefix[r] - prefix[l]
So yes, we are turning the problem from repeated additions to a subtraction check.

Key takeaway
Brute force: Add for each subarray (O(N²))
Optimized: Keep one running sum, subtract using hashmap to count valid subarrays (O(N))
Both ways get the same result.
Do you want me to show a table for your example showing:
cumulative sum
map lookups (subtraction)
how it finds balanced subarrays without explicitly adding?
 */