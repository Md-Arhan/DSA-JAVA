class Solution {
    public int maxSumSubarray(int[] arr) {

        int currSum = arr[0];          // Maximum sum ending here without deletion
        int deleteEle = arr[0]; // Maximum sum ending here after one deletion
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int oldCurrSum = currSum;

            // Normal Kadane
            currSum = Math.max(currSum + arr[i], arr[i]);

            // Either delete current element or deletion was already used
            deleteEle = Math.max(oldCurrSum, deleteEle + arr[i]);

            ans = Math.max(ans, Math.max(currSum, deleteEle));
        }

        return ans;
    }
}

/*
Why doesn't it delete twice?

Because this transition:

deleteEle + arr[i]

never deletes the current element.

It only adds it.

So once you're in the deleteEle state, every future element is included normally.

Think of it like doors
            currSum
      (deletion not used)
          /         \
 keep arr[i]     delete arr[i]
     |                |
     v                v
 currSum         deleteEle
                     |
                     |
             keep arr[i]
                     |
                     v
               deleteEle

Notice there's no arrow from deleteEle back to another "delete" action.

Once you enter deleteEle, you've spent your one deletion. Every subsequent update is just:

deleteEle = deleteEle + arr[i];

(or you compare against deleting the current element from the currSum path).

So the DP state itself guarantees that at most one deletion is ever used.

This is the key idea in many DP problems: the state encodes what actions are still available. Here, deleteEle means "the deletion has already been consumed," so a second deletion is impossible.

how the intution is working explain

The intuition becomes much easier if you think about what each state promises, not the formulas.

Step 1: Normal Kadane

In Kadane, we maintain:

currSum

Meaning:

Best subarray ending at index i without any deletion.

Example:

2  -1  3

At 3,

currSum = 4

because

2 + (-1) + 3 = 4
Step 2: Now allow one deletion

Let's define another state.

deleteEle

Meaning:

Best subarray ending at index i after using one deletion somewhere.

Notice the words "somewhere".

We don't care where it happened.

We only care that it has already happened exactly once.

Step 3: How can we reach this state?

Suppose we're standing at

4  -1  -2
        ↑
      current

We want the best answer ending at -2 with one deletion.

Ask yourself:

Where could that deletion be?

There are only two answers.

Case 1: Delete the current element

Delete -2.

Then the subarray is

4  -1

Its sum is

3

Where did this 3 come from?

It is simply the best subarray before the current index without deletion.

That is

oldCurrSum
Case 2: Delete happened earlier

Suppose we already deleted -1.

Then our subarray before reaching -2 is

4

Current element is -2.

We cannot delete again.

So we must include it.

4 + (-2)
=
2

That is

deleteEle + arr[i]
That's it!

There is no third possibility.

Whenever you are computing

deleteEle

you ask

"Where is my one deletion?"

Either

it is today
or it happened before today

Nothing else is possible.

Hence

deleteEle =
Math.max(
    oldCurrSum,
    deleteEle + arr[i]
);
*/