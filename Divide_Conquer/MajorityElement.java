package Divide_Conquer;

public class MajorityElement {
    public static int majorityElement(int arr[], int si, int ei){
        //base case
        if(si>=ei){
            return arr[si];
        }

        //work
        int mid = si + (ei - si)/2;
        int left = majorityElement(arr, si, mid);
        int right = majorityElement(arr, mid+1, ei);

        if(left == right){
            return left;
        }

        int leftCount = countInRange(arr, left, si, mid);
        int rightCount = countInRange(arr, right, mid+1, ei);

        return leftCount > rightCount ? left : right;

    }

    public static int countInRange(int []arr, int num, int si, int ei){
       int count = 0;
       for(int i=si; i<=ei; i++){
        if(arr[i] == num) count++;
       }
       return count;
       
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 3, 3, 2, 2, 3, 3, 4, 4 , 4, 4};
        int res = majorityElement(arr, 0, arr.length-1);
        System.out.println(res);

    }
}
