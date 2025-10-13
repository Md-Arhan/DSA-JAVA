package Recursion;

public class FirstLasrOccurence {
    public static int firstOccurence(int arr[], int i, int key){
        if(i == arr.length-1){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurence(arr, i+1, key);
    }

    public static int lastOccurence(int arr[], int i, int key){
        if(i == arr.length-1){
            return -1;
        }

        int isFound = lastOccurence(arr, i+1, key);

        // if(isFound != -1){
        //     return isFound;
        // }

        // //check with self

        // if(arr[i] == key){
        //     return i;
        // }
        // return isFound;

        //Concize the program

        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;

    }

    public static void main(String []args){
      int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
      System.out.println(lastOccurence(arr, 0, 5));
    }
}
