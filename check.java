import java.util.*;

public class check {

    // // static ArrayList<Integer> ans = new ArrayList<>();

    // public static void find(int[] digits, boolean isTrue[], int index, String str) {

    //     if (str.length() == 3) {
    //         if (str.charAt(0) != '0' && Integer.parseInt(str) % 2 == 0) {
    //             ans.add(Integer.parseInt(str));
    //         }
    //         return;
    //     }

    //     for (int i = 0; i < digits.length; i++) {

    //         if (isTrue[i])
    //             continue;

    //         isTrue[i] = true;

    //         find(digits, isTrue, index + 1, str + digits[i]);

    //         // backtrack
    //         isTrue[i] = false;
    //     }
    // }

    // static Set<Integer> ans = new TreeSet<>();

    // public static boolean isNumber(int number, HashMap<Integer, Integer> map) {
    //     HashMap<Integer, Integer> digiCount = new HashMap<>(map);

    //     while (number > 0) {
    //         int lastDigi = number % 10;
    //         if (digiCount.containsKey(lastDigi)) {
    //             int count = digiCount.get(lastDigi); // safely get the count
    //             if (count == 0) {
    //                 return false;
    //             }
    //             digiCount.put(lastDigi, digiCount.get(lastDigi) - 1); // update the count
    //         }
    //         number /= 10;
    //     }

    //     return true;
    // }

    // public static int[] findEvenNumbers(int[] digits) {

    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for (int i = 0; i < digits.length; i++) {
    //         if (map.containsKey(digits[i])) {
    //             map.put(digits[i], map.get(digits[i]) + 1);
    //         } else {
    //             map.put(digits[i], 1);
    //         }
    //     }

    //     for (int i = 100; i <= 999; i += 2) {
    //         if (isNumber(i, map)) {
    //             ans.add(i);
    //         }
    //     }

    //     // Convert list to array
    //     int[] res = new int[ans.size()];
    //     int i = 0;
    //     for (int val : ans) {
    //         res[i++] = val;
    //     }

    //     return res;

    // }

    // public static void main(String[] args) {

    //     // int digits[] = { 2, 1, 3, 0 };
    //     // boolean isTrue[] = new boolean[digits.length];
    //     // find(digits, isTrue, 0, "");
    //     // for(int i=0; i<ans.size(); i++){
    //     // System.out.println(ans.get(i));
    //     // }

    //     // int arr[] = findEvenNumbers(digits);

    //     // int digits[] = {1, 2, 3};
    //     // int aux[] = new int[digits.length + 1];
    //     // String num = "";

    //     // for(int i=0; i<digits.length; i++){
    //     // num = num + digits[i];
    //     // }

    //     // int finalInteger = Integer.parseInt(num);
    //     // finalInteger++;

    //     // String str = finalInteger + "";

    //     // for(int i=0; i<str.length(); i++){
    //     // aux[i] = str.charAt(i) - '0';
    //     // }

    //     // for(int i=0; i<aux.length; i++){
    //     // System.out.println(aux[i]);
    //     // }

    //     // int[][] matrix1 = {
    //     // {1, 2, 3},
    //     // {4, 5, 6},
    //     // {7, 8, 9}
    //     // };

    //     // int n = matrix1.length;
    //     // int m = matrix1[0].length;

    //     // System.out.println(n);
    //     // System.out.println(m);
    //     // System.out.println(3/2);
    //     // System.out.println(Math.ceil(ap12.0/3));
    //     // System.out.println(1+(1-1) / 2);
    //     // // System.out.println("303" > "323");
    //     // System.out.println("322".equals(0));
    //     // System.out.println((2+3)/2);
    //     // String s = "";
    //     // s+=10;
    //     // System.out.println(s+8);
    //     // char ch = 'a';
    //     // ch++;
    //     // System.out.println(ch);

        
    // }

    // static class Node{
    //     Node[] children;
    //     int freq;

    //     public Node(){
    //         children = new Node[26];
    //         for(int i=0; i<26; i++){
    //             children[i] = null;
    //         }
    //         freq = 0;
    //     }
    // }

    // private static final Node root = new Node();
    // static int max = 0;
    // static String ans = "";

    // public static void insert(String word){
    //     Node curr = root;
    //     for(int i=0; i<word.length(); i++){
    //        int idx = word.charAt(i) - 'a';
    //        if(curr.children[idx] == null){
    //          curr.children[idx] = new Node();
    //        }
    //         curr = curr.children[idx];
    //         int val = ++curr.freq;
    //         max = Math.max(max, val);
    //     }
    // }

    // public static void longest(Node root){
    //     if(root == null){
    //         return;
    //     }

    //     if(root.freq < max){
    //        return;
    //     }

    //     for(int i=0; i<root.children.length; i++){
    //         if(root.children[i] != null && root.children[i].freq == max){
    //             ans+= (char) (i + 'a');
    //             longest(root.children[i]);
    //         }
    //     }
    // }

    // public static void longestCommonPrefix(String[] strs) {
    //     if(max < 2){
    //         return "";
    //     }

    //     longest(root);
    // }

    public static void main(String[] args) {
        // String[] strs = {"flower", "flow", "flight"};
        // for(int i=0; i<strs.length; i++){
        //     insert(strs[i]);
        // }

        // if(max < 2){
        //     System.out.println("ee");
        // }
        // System.out.println(max);
        // root.freq = max;
        // longest(root);
        // System.out.println(ans);
        // String ans = "Arhan";
        // System.out.println(ans.startsWith("Arh"));
        // System.out.println(ans.endsWith("han"));

        // int cut = 1;
        // for(int i=1; i<n; i++){
        //     cut++;
        //     if(cut == numfriends){
        //         arr[idx++] = words.substring(i);
        //         cut--;
        //     }
        //     arr[idx++] = words.substring(0, i);
        // }

        // int sum = -2147483648 / -1;
        // int res = (int)sum;

        // System.out.println(res);

        System.out.println(1<1);
    }
}
