package Recursion;

public class Length {

    public static void lengthOfString(int arr[], int i){
        if(i == arr.length-1){
            System.out.println(i);
            return;
        }

        System.out.println(i);
        lengthOfString(arr, i+1);
    }

    public static int length(String str){
       if(str.length() == 0){
          return 0;
       }

       return length(str.substring(1)) + 1;
    }

    public static void main(String []args){
        int arr[] = {2, 3, 4, 5, 6, 7, 8 , 9};
        lengthOfString(arr, 0);

        String str = "abcd";
        System.out.println(length(str));
    }
}
