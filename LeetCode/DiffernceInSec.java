import java.util.Arrays;

public class DiffernceInSec {
    private int seconds(String s){
        
        int hours = Integer.parseInt(s.substring(0, 2));
        int time = Integer.parseInt(s.substring(3, 5));
        int sec = Integer.parseInt(s.substring(6, 8));
        
        return hours * 3600 + time * 60 + sec;
    }
    
    public int minDifference(String[] arr) {
        // code here
        int n = arr.length;
        int temp[] = new int[n];
        
        for(int i=0; i<n; i++){
            temp[i] = seconds(arr[i]);
        }
        
        Arrays.sort(temp);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<n; i++){
            min = Math.min(min, temp[i] - temp[i-1]);
        }
        
        int wrapAround = 86400 - temp[n-1] + temp[0];
        min = Math.min(min, wrapAround);
        
        return min;
    }
}


/*
 * Let's analyze each part:
🔹 1. time.substring(start, end)
Example: time.substring(0, 2) returns "23"

Java’s substring(start, end) takes a slice of the string from start to end - 1

Time complexity depends on how substring is implemented.

🔍 In modern Java (Java 7+):
Substring creates a new character array

Copies end - start characters into a new string

But in your case, you're always copying 2 characters

✅ So:
time.substring(0, 2); // 2 chars only → O(1)
Same for "59" and "59" → all substring calls here are constant-time.

🔹 2. Integer.parseInt(str)
This parses a short string like "23", "59", or "01".

Time complexity: O(k), where k is the number of characters in the string

But here k is always 2

✅ So:

Integer.parseInt("23")  // O(2) → O(1)
In your case, the inputs are always 2-digit strings (max 3 if "100", but not in 24-hour time), so it's effectively constant time.
 */

 /*
  * Correct Statement:
Since every operation is constant time, the overall time complexity is O(1), not O(!).
  */




/*✅ The Clock is Circular
Time in "HH:MM:SS" is cyclical. After "23:59:59", the next second is "00:00:00".

So when comparing "23:59:59" and "00:00:01", you must calculate the wrap-around time difference: */