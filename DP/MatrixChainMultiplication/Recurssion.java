package DP.MatrixChainMultiplication;

public class Recurssion {

    public static int mcm(int arr[], int i, int j) {
        if (i == j) {
            return 0;   //Single matrix case
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = mcm(arr, i, k); // Ai....Ak => arr[i-1] x arr[k]
            int cost2 = mcm(arr, k + 1, j); // Ai+1..aj +> arr[k] x arr[j]
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 3 }; // n = 5;
        int n = arr.length;

        System.out.println(mcm(arr, 1, n - 1));
    }

}


/*
 * Associativity Property:
The associativity property in mathematics refers to how the grouping of numbers does not affect the result of an operation, as long as the operation is associative.
✅ Definition:
For an operation ∗, the associativity property means:
(a∗b)∗c=a∗(b∗c)
This property holds true for:
Addition:(a+b)+c=a+(b+c)
Multiplication:(a×b)×c=a×(b×c)
 */

 /*

 int[] arr = {10, 20, 30, 40, 50};
This means:

A = 10x20
B = 20x30
C = 30x40
D = 40x50
  * 
  mcm(1, 4)
├─ Try k = 1 → (A)(BCD)
│  ├─ cost1 = mcm(1, 1) = 0
│  ├─ cost2 = mcm(2, 4)
│  │  ├─ Try k = 2 → (B)(CD)
│  │  │  ├─ cost1 = mcm(2, 2) = 0
│  │  │  ├─ cost2 = mcm(3, 4)
│  │  │  │  ├─ k = 3
│  │  │  │  ├─ cost1 = mcm(3, 3) = 0
│  │  │  │  ├─ cost2 = mcm(4, 4) = 0
│  │  │  │  ├─ cost3 = arr[2] * arr[3] * arr[4] = 30*40*50 = 60000
│  │  │  │  └─ final = 0 + 0 + 60000 = 60000
│  │  │  ├─ cost3 = arr[1] * arr[2] * arr[4] = 20*30*50 = 30000
│  │  │  └─ final = 0 + 60000 + 30000 = 90000
│  │  ├─ Try k = 3 → (BC)(D)
│  │  │  ├─ cost1 = mcm(2, 3)
│  │  │  │  ├─ k = 2
│  │  │  │  ├─ cost1 = 0, cost2 = 0
│  │  │  │  ├─ cost3 = 20*30*40 = 24000
│  │  │  │  └─ final = 24000
│  │  │  ├─ cost2 = mcm(4, 4) = 0
│  │  │  ├─ cost3 = 20*40*50 = 40000
│  │  │  └─ final = 24000 + 0 + 40000 = 64000
│  │  └─ min(90000, 64000) = 64000
│  ├─ cost3 = 10*20*50 = 10000
│  └─ final = 0 + 64000 + 10000 = 74000

├─ Try k = 2 → (AB)(CD)
│  ├─ cost1 = mcm(1, 2)
│  │  ├─ k = 1
│  │  ├─ cost1 = 0, cost2 = 0
│  │  ├─ cost3 = 10*20*30 = 6000
│  │  └─ final = 6000
│  ├─ cost2 = mcm(3, 4)
│  │  ├─ Already computed = 60000
│  ├─ cost3 = 10*30*50 = 15000
│  └─ final = 6000 + 60000 + 15000 = 81000

├─ Try k = 3 → (ABC)(D)
│  ├─ cost1 = mcm(1, 3)
│  │  ├─ Try k = 1 → (A)(BC)
│  │  │  ├─ mcm(2, 3)
│  │  │  │  ├─ k=2, cost3=24000
│  │  │  ├─ cost3 = 10*20*40 = 8000
│  │  │  └─ total = 0 + 24000 + 8000 = 32000
│  │  ├─ Try k = 2 → (AB)(C)
│  │  │  ├─ mcm(1, 2) = 6000
│  │  │  ├─ cost3 = 10*30*40 = 12000
│  │  │  └─ total = 6000 + 0 + 12000 = 18000
│  │  └─ min(32000, 18000) = 18000
│  ├─ cost2 = mcm(4, 4) = 0
│  ├─ cost3 = 10*40*50 = 20000
│  └─ final = 18000 + 0 + 20000 = 38000 ✅

---

### ✅ Final Answer:
The minimum number of multiplications to compute A×B×C×D is:

  */