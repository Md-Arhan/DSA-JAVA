package Strings;

import java.util.Arrays;

public class Anagrams {
    
    public static void main(String[] args) {
        String s1 = "tea";
        String s2 = "eats";

        if(s1.length() == s2.length()){
            char s1Arr[] = s1.toCharArray();  //['t', 'e', 'a']
            char s2Arr[] = s2.toCharArray();  //['e', 'a', 't']

            Arrays.sort(s1Arr);
            Arrays.sort(s2Arr);

            System.out.println(Arrays.equals(s1Arr, s2Arr)+ " this is anagram");  //Arrays method to check the array is equal
        }else{
            System.out.println(s1 + " and " + s2 + " is not a anagram");
        }


    }
}
