package DP.MatrixChainMultiplication;

public class Tabulation {

    public static void print(int dp[][]){
        int n = dp.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        // Initialization
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Bottom up
 
        for (int len = 2; len <= n - 1; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + cost3);
                }
            }
        }
        



        print(dp);
        return dp[1][n-1];

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 };
        System.out.println(mcmTab(arr));

    }
}



/*
 * Now for len = 2 (subchains of 2 matrices):
1️⃣ i = 1, j = 2
k = 1:
cost1 = dp[1][1] = 0
cost2 = dp[2][2] = 0
cost3 = arr[0] * arr[1] * arr[2] = 1*2*3 = 6
dp[1][2] = 6

2️⃣ i = 2, j = 3
k = 2:
2*3*4 = 24
dp[2][3] = 24

3️⃣ i = 3, j = 4
k = 3:
3*4*3 = 36
dp[3][4] = 36

DP table now:

      0      1      2      3      4
0   [ 0,     0,     0,     0,     0 ]
1   [ 0,     0,     6,     0,     0 ]
2   [ 0,     0,     0,    24,     0 ]
3   [ 0,     0,     0,     0,    36 ]
4   [ 0,     0,     0,     0,     0 ]
🔁 len = 3 (subchains of 3 matrices)
1️⃣ i = 1, j = 3
k = 1:
cost1 = 0, cost2 = 24, cost3 = 1*2*4 = 8 → total = 32

k = 2:
cost1 = 6, cost2 = 0, cost3 = 1*3*4 = 12 → total = 18 ✅
→ dp[1][3] = 18

2️⃣ i = 2, j = 4
k = 2:
cost1 = 0, cost2 = 36, cost3 = 2*3*3 = 18 → total = 54

k = 3:
cost1 = 24, cost2 = 0, cost3 = 2*4*3 = 24 → total = 48 ✅
→ dp[2][4] = 48

DP table now:

      0      1      2      3      4
0   [ 0,     0,     0,     0,     0 ]
1   [ 0,     0,     6,    18,     0 ]
2   [ 0,     0,     0,    24,    48 ]
3   [ 0,     0,     0,     0,    36 ]
4   [ 0,     0,     0,     0,     0 ]
🔁 len = 4 (whole chain: M1 to M4)
i = 1, j = 4
Try all k from 1 to 3:

k = 1:
cost1 = 0, cost2 = 48, cost3 = 1*2*3 = 6 → total = 54

k = 2:
cost1 = 6, cost2 = 36, cost3 = 1*3*3 = 9 → total = 51

k = 3:
cost1 = 18, cost2 = 0, cost3 = 1*4*3 = 12 → total = 30 ✅

→ dp[1][4] = 30

✅ Final DP Table:

      0      1      2      3      4
0   [ 0,     0,     0,     0,     0 ]
1   [ 0,     0,     6,    18,    30 ]
2   [ 0,     0,     0,    24,    48 ]
3   [ 0,     0,     0,     0,    36 ]
4   [ 0,     0,     0,     0,     0 ]
🎯 Final Result:
java
Copy
Edit
return dp[1][4]; // 30
So, the minimum number of multiplications for {1, 2, 3, 4, 3} is 30.

Let me know if you want the multiplication order or want to see it visualized!

 */



 

/*
Find the minimum number of scalar multiplications needed to multiply all these matrices together.
We cannot change the order of matrices, but we can change the placement of parentheses to minimize computation.

🔍 Step-by-Step Explanation:
✅ Step 1: Understand What We’re Solving
Each matrix multiplication takes effort based on its dimensions:
To multiply a matrix A of size p × q with B of size q × r → cost = p * q * r

We want to group matrices optimally to minimize total cost.

✅ Step 2: Define the DP Table
We create a 2D table dp[i][j], where:

dp[i][j] stores the minimum multiplication cost to multiply matrices from i to j (1-based index).

So, dp[1][4] will be our final answer (for 4 matrices).

We fill this table bottom-up (small chains first, then bigger).

✅ Step 3: Initialization
We know that:

Multiplying one matrix (i.e., i == j) costs 0.
So:

for (int i = 0; i < n; i++)
    dp[i][i] = 0;
✅ Step 4: Fill DP Table Bottom-Up
We calculate the cost for all subchains of increasing length:

🔹 Chain length = 2 (subproblems of 2 matrices)
For all pairs (i, j) such that chain length = 2:

For (M1 × M2):
Cost = 1*2*3 = 6 → dp[1][2] = 6

For (M2 × M3):
Cost = 2*3*4 = 24 → dp[2][3] = 24

For (M3 × M4):
Cost = 3*4*3 = 36 → dp[3][4] = 36

🔹 Chain length = 3 (3 matrices)
For (M1 × M2 × M3) → dp[1][3]
We try all places to split the chain:

Split between M1 and (M2 × M3):

Cost = dp[1][1] + dp[2][3] + 1×2×4 = 0 + 24 + 8 = 32

Split between (M1 × M2) and M3:

Cost = dp[1][2] + dp[3][3] + 1×3×4 = 6 + 0 + 12 = 18 ✅
→ dp[1][3] = 18

For (M2 × M3 × M4) → dp[2][4]

Split between M2 and (M3 × M4):

Cost = 0 + 36 + 2×3×3 = 36 + 18 = 54

Split between (M2 × M3) and M4:

Cost = 24 + 0 + 2×4×3 = 24 + 24 = 48 ✅
→ dp[2][4] = 48

🔹 Chain length = 4 (All 4 matrices)
For (M1 × M2 × M3 × M4) → dp[1][4]

Try all splits:

Split between M1 and (M2 × M3 × M4):

Cost = 0 + 48 + 1×2×3 = 48 + 6 = 54

Split between (M1 × M2) and (M3 × M4):

Cost = 6 + 36 + 1×3×3 = 6 + 36 + 9 = 51

Split between (M1 × M2 × M3) and M4:

Cost = 18 + 0 + 1×4×3 = 18 + 12 = 30 ✅

→ dp[1][4] = 30

✅ Final Answer:
Minimum number of scalar multiplications = 30 
*/