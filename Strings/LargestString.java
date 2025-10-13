package Strings;

public class LargestString {

    public static int compareStrings(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());

        // Compare characters one by one
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }

        // If one string is a prefix of another, compare by length
        return s1.length() - s2.length();
    }

    public static void main(String[] args) {
        String fruits[] = { "apple", "mango", "banana" };

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) {
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}

/*
 * largest is compared with fruits[i].
 * If the result is less than 0, it means largest comes before fruits[i]
 * alphabetically.
 * This condition checks if fruits[i] is greater than largest lexicographically.
 */


 /*
  * largest	fruits[i]	largest.compareTo(fruits[i])	Condition Met?	largest Updated?
"Apple"	"Banana"	-1 (Apple < Banana)	Yes (< 0)	"Banana"
"Banana"	"Mango"	-1 (Banana < Mango)	Yes (< 0)	"Mango"
"Mango"	"Cherry"	1 (Mango > Cherry)	No	No


return s1.length() - s2.length();  // 5 - 3 = 2
Result: 2 > 0, so "apple" is greater than "app".


  */