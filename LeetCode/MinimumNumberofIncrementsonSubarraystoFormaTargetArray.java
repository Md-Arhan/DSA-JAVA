public class MinimumNumberofIncrementsonSubarraystoFormaTargetArray {
    public int minNumberOperations(int[] target) {
        int count = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                count += target[i] - target[i - 1];
            }
        }
        return count;
    }
}


/*
 * Problem idea (short recap)

You start from an array of zeros,
and you can choose any contiguous subarray and increment all its elements by 1 per operation.

You must find the minimum number of such operations to make the array equal to target.

🧠 Intuition behind the formula

Think of target as a series of heights.
We’re “painting” or “building” these heights from left to right using layer operations.

The key idea:

You only need to add new operations when the height goes up (increases).

When it goes down or stays the same, no new operations are needed.

So the total operations =
first element height + all increases in the array.
 */