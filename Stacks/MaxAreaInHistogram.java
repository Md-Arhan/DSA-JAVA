package Stacks;

import java.util.Stack;

//TC -> O(n)

public class MaxAreaInHistogram {
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right  -> n

        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left -> n

        s = new Stack<>();   //making stack empty

        for(int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = 0;  // 0 gives u the same answer but not the accurate one
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<nsr.length; i++){
            System.out.print(nsr[i]  + " ");
        }

        System.out.println();

        for(int i=0; i<nsl.length; i++){
            System.out.print(nsl[i]  + " ");
        }

        System.out.println();

        //Current Area  -> n

        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] -1;    // taking out the width
            int curr = height * width;
            System.out.print(curr + " ");
            maxArea = Math.max(maxArea, curr);
        }

        System.out.println();
        System.out.println("Maximum area in histogram is = " + maxArea);

    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 6, 2, 3};  //heights in histogram
        maxArea(arr);
    }
}

