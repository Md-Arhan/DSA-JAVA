class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        StringBuilder sb = new StringBuilder();

        while(n != 0){
            int remainder = n % 2;
            sb.append((char)(remainder + '0'));
            n/=2;
        }

        sb.reverse();
        int ans = 0;
        int m = sb.length();

        for(int i=m-1; i>=0; i--){
            if(i == 0 && sb.charAt(i) == '1') break;
            ans = ans * 2 + (sb.charAt(i) == '1' ? 0 : 1);
        }

        return ans;
    }
}   



/*
Two ways to convert binary → decimal
1️⃣ Right → Left (tracking powers)

Here we track powers of 2. 





Left → Right (calculating value)

Here we build the number directly.

Important takeaway

The issue is not just trailing zeros.

The real reason is:

👉 The formula ans = ans * 2 + bit assumes MSB → LSB processing.

So the loop must go:

left → right*/