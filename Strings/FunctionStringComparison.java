package Strings;

public class FunctionStringComparison {
    public static void main(String[] args) {
        String s1 = "Arhan";
        String s2 = "Arhan";   //String literal - String pool
        String s3 = new String("Arhan");  //String object - heap memory

        //intern() method

        System.out.println(s1==s3); //false bcz s3 is from heap memory and s1 is from pool

        String afterIntern = s3.intern();
        System.out.println(s1==afterIntern);


        if(s1 == s2){
            System.out.println("Eqaul");
        }else{
            System.out.println("not Equal");
        }

        if(s1 == s3){
            System.out.println("Eqaul");
        }else{
            System.out.println("not Equal");
        }

        System.out.println(s1.equals(s2));  //true return the boolean value

    }
}
