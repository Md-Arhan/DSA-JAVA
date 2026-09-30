 class Solution {
    public long sumXOR(int[] arr) {
        // code here
        long sum = 0;
        for (int i = 0; i < 32; i++) 
        {
            // Count of zeros and ones
            int zc = 0, oc = 0; 
            
            for (int j = 0; j < arr.length; j++)
            {
                if ((arr[j] >> i & 1) == 1)
                    oc++;
                else
                    zc++;
            }
            
            // Adding individual bit sum 
            sum += (long) oc * zc * (1 << i); 
        }
        return sum;
    }
}

/*At bit i
If two numbers differ → XOR gives 1
That contributes 2^i
🔹 So overall

👉 Count how many pairs differ at this bit
👉 Multiply by value of that bit

🔥 Core intuition (THIS is the real answer)

XOR = sum of contributions of all bits where numbers differ */