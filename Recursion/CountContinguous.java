package Recursion;

public class CountContinguous {
    public static int countContingousSubString(String str, int i, int j) {
        if (i > j) {
            return 0;
        }

        int firstCharRemoved = countContingousSubString(str, i + 1, j);
        int secCharRemoved = countContingousSubString(str, i, j - 1);
        int thirdCharRemoved = countContingousSubString(str, i + 1, j - 1);

        int res = firstCharRemoved + secCharRemoved - thirdCharRemoved;

        if (str.charAt(i) == str.charAt(j)) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "aba";
        int n = str.length();
        // System.out.println(n);
        System.out.println(countContingousSubString(str, 0, n - 1));
    }
}
