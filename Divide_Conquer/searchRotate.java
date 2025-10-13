package Divide_Conquer;

public class searchRotate {
    public static int searchRotated(int arr[], int tar, int si, int ei) {
        if (si > ei) {
          return -1;
        }
    
        // work
        int mid = (si + ei) / 2;
        if (arr[mid] == tar) {
          return mid;
        }
    
        // L1
        if ((arr[si] <= arr[mid])) {
          // case a
          if (arr[si] <= tar && tar <= arr[mid]) {
            return searchRotated(arr, tar, si, mid);
          }
           else {
            // case b
            return searchRotated(arr, tar, mid + 1, ei);
          }
    
        }
        // L2
        else {
          // case c:right
          if (arr[mid+1] <= tar && tar <= arr[ei]) {
            return searchRotated(arr, tar, mid + 1, ei);
          } else {
            // case d
            return searchRotated(arr, tar, si, mid);
          }
        }
    
      }
    
      public static void main(String[] args) {
        int arr[] = { 0, 1, 2,4, 5, 6, 7 };
        int target = 0;
        int result = searchRotated(arr, target, 0, arr.length - 1);
        System.out.println(result);
      }
}
