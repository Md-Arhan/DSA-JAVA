class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int neg = 0;
        long sum = 0;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int val = Math.abs(matrix[i][j]);
                sum+=val;
                if(matrix[i][j] < 0){
                    neg++;
                }
                smallest = Math.min(val, smallest);
            }
        }

        if(neg % 2 == 0){
            return sum;
        }

        return sum -= 2 * smallest;
    }
}

/* 
We focus on negative elements in the matrix.

Since every operation flips two adjacent cells,
we can always pair up negatives and make them positive.

Therefore:

if the count of negatives is even
→ we can make all values positive

if the count of negatives is odd
→ exactly one value must remain negative

To maximize the matrix sum:
we ensure the value that remains negative
is the one with the smallest absolute value

(because losing that one hurts the total the least)

So the matrix becomes:

all positive numbers

except possibly one smallest-magnitude value
*/