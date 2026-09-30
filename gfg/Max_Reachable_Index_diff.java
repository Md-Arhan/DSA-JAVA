class Solution {
    public int maxIndexDifference(String s) {
        // code here
        int st = -1;
        int n = s.length();
        int prev = -1;
        int en = -1;
        for(int i = 0; i < n; i++){
            int curr = s.charAt(i) - 'a';
            if(st == -1 && curr == 0){
                st = i;
                prev = 0;
                en = i;
            } else if(curr == 0){
                continue;
            } else if(curr - prev == 1){
                en = i;
                prev = curr;
            } else if(curr - prev <= 0){
                
                en = i;
            }
            
        }
        if(st == -1) return -1;
        
        return en - st;
    }
}


/*
Why doesn't prev change at the last 'b'?

This is the key idea of the algorithm.

At index 4, you've already reached 'c', so:

prev = 2 ('c')

When another 'b' appears:

a → b → c → b

The sequence has already progressed to 'c'. Seeing a smaller letter doesn't mean you should go backward. Therefore, the code simply extends en but keeps prev = 'c', so if a 'd' appears later, it can continue the sequence.

For example, with "aaabcbd":

a a a b c b d
          ^
          prev is still 'c'

At 'd':

curr = 3
prev = 2

3 - 2 = 1

So 'd' is accepted, because the algorithm remembers that it had already reached 'c', even though there was an extra 'b' in between.



It is a greedy state-tracking algorithm (or a finite state machine (FSM)-like approach) that keeps track of the highest alphabet character reached so far.




What it means

When curr <= prev:

This character has already been reached in our alphabetical chain.
So we don't need to update prev, because we've already progressed beyond this character.
However, since this occurrence is farther to the right, we can extend the ending index (en).

In other words, we're not trying to rebuild the chain—we're trying to maximize the distance.

Rephrased intuition

If the current character has already been visited in the alphabetical sequence (curr <= prev), don't move the sequence backward by updating prev. Instead, simply move en to this later occurrence because we can directly "jump" to it from the previously reached character. Since this character is already part of the valid chain, a later occurrence only increases the final index difference.

Even shorter version for future reference

If the current character is already covered in the sequence, don't update prev; only update en because a later occurrence gives a larger answer.
*/