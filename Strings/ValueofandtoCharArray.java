package Strings;

public class ValueofandtoCharArray {

    public static void main(String[] args) {
        int count = 12;
        String str = String.valueOf(count); // str = "12"
        char[] charArray = str.toCharArray(); // charArray = ['1', '2']

        System.out.println(charArray);
    }
}
