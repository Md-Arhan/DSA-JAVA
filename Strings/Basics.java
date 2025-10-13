package Strings;
import java.util.*;

public class Basics {
    
    public static void printLetters(String str){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e'||str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                System.out.println("present at index " + i+ " ");

            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // char ch[] = {'a', 'b', 'c', 'd'};
        // String str = "abcd";
        // String  str1 = new String("xyz");

        // System.out.println(str);
        // System.out.println(str1);
        
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.nextLine();
        System.out.println(name.length());
        sc.close();

        //Concatination
        String firstName = "Mohammed Arhan";
        String  lastName = "Ur Rehman";
        String fullName = firstName + lastName; 
        System.out.println(fullName);   //Concatination, Merging of two Strings

        //charAt()

        System.out.println(fullName.charAt(1));

        printLetters(fullName);
    }
}
