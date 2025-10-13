package BackTracking;

public class Permutation {
    public static void findPermutation(String str, String ans) {

        // Base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // recursion
        // for(int i=0; i<str.length(); i++){
        // char curr = str.charAt(i);
        // // System.out.println(curr);
        // //subString = suppose it's "abcde" = "ab" + "de" = "abde";
        // String newStr = str.substring(0, i) + str.substring(i+1);
        // // System.out.println(newStr);
        // findPermutation(newStr, ans+curr);
        // }

        for (int i = 0; i < str.length(); i++) {
            // char curr = str.charAt(i);

            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newStr, ans + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutation(str, "");
    }
}