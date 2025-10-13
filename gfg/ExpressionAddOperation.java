public class ExpressionAddOperation {
    ArrayList<String> ans;
    int n;
    String num;
    int target;
    
    public void solve(int index, long currVal, long prevNum, StringBuilder expr){
        if (index == n) {
            if (currVal == target) ans.add(expr.toString());
            return;
        }
        
        for(int i=index; i<n; i++){
            if (i != index && num.charAt(index) == '0') break;
            long val = Long.parseLong(num.substring(index, i + 1));
            int len = expr.length();

            if (index == 0) {
                // first number, no operator
                expr.append(val);
                solve(i + 1, val, val, expr);
                expr.setLength(len);
            } else {
                // addition
                expr.append('+').append(val);
                solve(i + 1, currVal + val, val, expr);
                expr.setLength(len);

                // subtraction
                expr.append('-').append(val);
                solve(i + 1, currVal - val, -val, expr);
                expr.setLength(len);

                // multiplication
                expr.append('*').append(val);
                solve(i + 1, currVal - prevNum + prevNum * val, prevNum * val, expr);
                expr.setLength(len);
            }
        }
    }    
    
    public ArrayList<String> findExpr(String s, int target) {
        // code here
        ans = new ArrayList<>();
        num = s;
        n = s.length();
        this.target = target;
        solve(0, 0, 0, new StringBuilder());
        return ans;
    }
}


/*
 *Step 1 — Take first number(s) from index 0

"1" → expr = "1", currVal = 1, prevNum = 1

"12" → expr = "12", currVal = 12, prevNum = 12

"124" → expr = "124", currVal = 124, prevNum = 124

We recurse from the next index after the number.

Step 2 — Branch "1" (index = 1, remaining "24")

Next number(s) from index 1:

"2"

"24"

Sub-branch "2"

Operators: +, -, *

"1+2" → currVal = 3, prevNum = 2, expr = "1+2"

Remaining "4" → next recursion:

"1+2+4" → 7 ❌

"1+2-4" → -1 ❌

"1+2*4" → currVal = 3 - 2 + 2*4 = 9 ❌

"1-2" → currVal = -1, prevNum = -2, expr = "1-2"

Remaining "4" → next recursion:

"1-2+4" → 3 ❌

"1-2-4" → -5 ❌

"1-2*4" → currVal = -1 - (-2) + (-2*4) = -7 ❌

"1*2" → currVal = 2, prevNum = 2, expr = "1*2"

Remaining "4" → next recursion:

"1*2+4" → 6 ✅ ✅ target hit → add "1*2+4"

"1*2-4" → -2 ❌

"1*2*4" → 8 ❌
 */