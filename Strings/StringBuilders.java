package Strings;

public class StringBuilders {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<='z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb.length());

        String str = "Tony";
        for(char ch='a'; ch<='z'; ch++){
            str+=ch;
        }
        System.out.println(str.length());
    }
}
