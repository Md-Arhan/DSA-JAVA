import java.util.HashMap;
import java.util.Map;

public class FractionToRecuringDecimal {
     public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long quotient = (dividend / divisor);
        long remainder = dividend % divisor;
        boolean negative = (numerator < 0) ^ (denominator < 0);

        StringBuilder ans = new StringBuilder();
        if(negative) ans.append('-');
        ans.append(quotient);

        // If no remainder, division terminates
        if (remainder == 0) return ans.toString();

        ans.append('.');

        Map<Long, Integer> remainderMap = new HashMap<>();
        StringBuilder decimal = new StringBuilder();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                int repeatIndex = remainderMap.get(remainder);
                decimal.insert(repeatIndex, '(');
                decimal.append(')');
                break;
            }

            // Store remainder with its position
            remainderMap.put(remainder, decimal.length());

            remainder *= 10;
            long digit = Math.abs(remainder / denominator);
        
            decimal.append(digit);
            remainder %= denominator;
        }

        ans.append(decimal);
        return ans.toString();
    }
}


/*
 * what you’re doing in your code is essentially the manual long division algorithm for computing decimals. There isn’t a single “formula” per se; it’s a process using the remainder to generate decimal digits one by one. Let me explain clearly.
 * 
 * Why it works

This is exactly what you do in paper long division:

When you “bring down a 0” after the decimal point, you’re multiplying the remainder by 10.

Then divide by the denominator to get the next digit.

Update the remainder to continue to the next digit.

Example: 1 ÷ 2

quotient = 0, remainder = 1

Multiply remainder by 10 → 10

10 / 2 = 5 → first decimal digit

New remainder 10 % 2 = 0 → stop

Result = 0.5 ✅
 */