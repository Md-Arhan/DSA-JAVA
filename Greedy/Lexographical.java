public class Lexographical {
    public static String getSmallesrtString(int N, int K){
        char[] result = new char[N];
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }

        // Calculate the remaining sum
        int remainingSum = K - N;

        // Distribute the remaining sum from right to left
        // for (int i = 0; i < N && remainingSum > 0; i++)  //LexicographicallyLargestString
        for (int i = N - 1; i >= 0 && remainingSum > 0; i--) {
            int addValue = Math.min(25, remainingSum); // Maximum value to add is 25
            result[i] += addValue;
            remainingSum -= addValue;
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(getSmallesrtString(5, 73));
    }
}



/*
 *  Step-by-Step Dry Run
Step 1: Initialize all characters to 'a'
java
Copy
Edit
char[] result = new char[N];  // result = [ , , , , ]
for (int i = 0; i < N; i++) {
    result[i] = 'a';          // Fill with 'a'
}
✅ result = ['a', 'a', 'a', 'a', 'a']
➡️ Total value = 5 × 1 = 5

Step 2: Calculate remaining sum to distribute
java
Copy
Edit
int remainingSum = K - N;  // 73 - 5 = 68
✅ remainingSum = 68

We now need to increase characters to make the total sum reach 73.

Step 3: Distribute the remaining sum from right to left
java
Copy
Edit
for (int i = N - 1; i >= 0 && remainingSum > 0; i--) {
🔄 Loop Iteration 1 (i = 4)
java
Copy
Edit
addValue = Math.min(25, 68) = 25
result[4] = 'a' + 25 = 'z'
remainingSum = 68 - 25 = 43
✅ result = ['a', 'a', 'a', 'a', 'z']

🔄 Loop Iteration 2 (i = 3)
java
Copy
Edit
addValue = Math.min(25, 43) = 25
result[3] = 'a' + 25 = 'z'
remainingSum = 43 - 25 = 18
✅ result = ['a', 'a', 'a', 'z', 'z']

🔄 Loop Iteration 3 (i = 2)
java
Copy
Edit
addValue = Math.min(25, 18) = 18
result[2] = 'a' + 18 = 's'  // ASCII 'a' = 97 → 97 + 18 = 115 → 's'
remainingSum = 18 - 18 = 0
✅ result = ['a', 'a', 's', 'z', 'z']

🧾 Final Result:
java
Copy
Edit
return new String(result);
✅ Output = "aaszz"

✅ Final String: "aaszz"
Total sum:
a = 1
a = 1
s = 19
z = 26
z = 26
→ 1 + 1 + 19 + 26 + 26 = 73 ✅

Lexicographically smallest possible string for that value ✅
 */