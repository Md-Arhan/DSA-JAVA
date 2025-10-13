package Strings;

public class SplitFunction {

    public static void split() {
        String str = "Java is awesome";
        String[] words = str.split(" "); // Split by space

        for (String word : words) {
            System.out.println(word);
        }

    }

    public static void main(String[] args) {
        String str = "one,two,three,four,five";
        String[] result = str.split(",", 3);

        for (String s : result) {
            System.out.println(s);
        }
    }
}

/*
 1.
 * apple
 * banana
 * grape
 * orange

 2. 
 * one
 * two
 * three,four,five
 */