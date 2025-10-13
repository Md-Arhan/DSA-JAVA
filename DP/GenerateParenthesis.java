package DP;

public class GenerateParenthesis {
    
}


/*
 * Your Claim:
"For n pairs of parentheses, the string length is 2n, and since we make at most 2 calls at each step, shouldn't the total calls be O(2^2n) = O(4^n)? So isn’t it just 2n levels with at most 2 calls each?"

That feels logical at first glance. But the key insight is:

The number of valid strings of parentheses is not determined just by the number of recursive calls.
 */