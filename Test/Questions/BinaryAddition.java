package Test.Questions;

public class BinaryAddition {
    class Solution {
        public String addBinary(String a, String b) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();

            int i = a.length() - 1;
            int j = b.length() - 1;

            while (i >= 0 || j >= 0 || carry == 1) {
                int sum = carry;

                if (i >= 0) {
                    sum += a.charAt(i) - '0';
                    i--;
                }

                if (j >= 0) {
                    sum += b.charAt(j) - '0';
                    j--;
                }

                sb.append(sum % 2);
                carry = sum / 2;
            }

            return sb.reverse().toString();
        }
    }
}

/*
 * ✅ 1️⃣ Binary Basics
 * 
 * Binary = Base 2
 * 
 * Digits allowed:
 * 
 * 0 and 1 only
 * 
 * ✅ 2️⃣ Golden Math Rule (ALL Number Systems)
 * 
 * For base B:
 * 
 * Digit = n % B
 * Remaining = n / B
 * 
 * 
 * 🧠 Remember:
 * 
 * % → KEEP digit
 * / → DROP digit
 * 
 * ✅ 3️⃣ Binary Conversion (Decimal → Binary)
 * Bit = n % 2
 * Next = n / 2
 * 
 * 
 * ✔ % 2 → extracts last bit
 * ✔ / 2 → shifts number right
 * 
 * ✅ 4️⃣ Binary Addition Core Rule
 * 
 * In ONE column we add:
 * 
 * bitA + bitB + carry
 * 
 * 
 * Each is 0 or 1
 * 
 * ✅ 5️⃣ Maximum Sum Rule 🔥
 * Max = 1 + 1 + 1 = 3
 * 
 * 
 * 🧠 IMPORTANT MEMORY LINE:
 * 
 * 👉 Binary column sum NEVER exceeds 3
 * 
 * ✅ 6️⃣ Extract Result & Carry
 * 
 * From:
 * 
 * sum = carry + A + B
 * 
 * 
 * Use:
 * 
 * Result Bit = sum % 2
 * Carry = sum / 2
 * 
 * 
 * ✔ Always valid ✅
 * ✔ Carry always 0 or 1 ✅
 */