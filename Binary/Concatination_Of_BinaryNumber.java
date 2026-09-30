class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long ans = 0;
        int bits = 0;

        for(int i = 1; i <= n; i++) {

            // if i is power of 2, bit length increases
            if((i & (i - 1)) == 0) {
                bits++;
            }

            ans = ((ans << bits) + i) % MOD;
        }

        return (int)ans;
    }
}



/*

This is the core insight of that solution.

You’re asking:

Why does the bit length increase only when i is a power of 2?

Let’s break it visually.

🧠 Observe Binary Pattern

Look at numbers in binary:

1  = 1        (1 bit)
2  = 10       (2 bits)
3  = 11       (2 bits)
4  = 100      (3 bits)
5  = 101      (3 bits)
6  = 110      (3 bits)
7  = 111      (3 bits)
8  = 1000     (4 bits)

Notice something 👀

Bit-length increases at:

1 → 2 → 4 → 8 → 16 → ...

Those are exactly:

2^0, 2^1, 2^2, 2^3, ...

👉 Powers of 2.



Why We Use (i & (i-1)) == 0

All powers of 2 look like:

1000
0100
0010
0001

Subtract 1:

1000
0111

AND:

1000
0111
----
0000

Only powers of 2 produce 0.Number*/