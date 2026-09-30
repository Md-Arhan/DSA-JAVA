public class kth_Bit_In_BinaryString {
    class Solution {
        public char findKthBit(int n, int k) {
            StringBuilder sb = new StringBuilder("0");

            for (int i = 2; i <= n; i++) {

                StringBuilder temp = new StringBuilder(sb);

                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '0')
                        temp.setCharAt(j, '1');
                    else
                        temp.setCharAt(j, '0');
                }

                temp.reverse();

                sb = new StringBuilder(sb + "1" + temp);
            }

            return sb.charAt(k - 1);
        }

    }
}


/*
Let’s Compute Lengths

Start with:

S1 = "0"
length = 1
S2
S2 = "011"
length = 3
S3
S3 = "0111001"
length = 7
S4
length = 15
S5
length = 31

Pattern:

1
3
7
15
31

This follows:

length = 2^n - 1

Example:

n = 4
2^4 - 1 = 15
3️⃣ Why Time Complexity = C

In the brute force solution we build the entire string.

For Sn, we must process about:

2^n - 1 characters

Operations like:

copy

invert

reverse

concatenate

all work proportional to the string length.

So total operations ≈

O(2^n) */