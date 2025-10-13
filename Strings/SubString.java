package Strings;

public class SubString {
    
    public static String subString(String str, int si, int ei){
        String subStr = " ";
        for(int i=si; i<ei; i++){
            subStr+= str.charAt(i);
        }
        return subStr;
    } 

    public static void main(String[] args) {
        String str = "Arhan";
        System.out.println(str.substring(0,3));
        System.out.println(subString(str, 1, 3));

    }
}
