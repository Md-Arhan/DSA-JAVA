import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//Minimum Operations to Halve Array Sum

//Initial sum = 33.
// Target sum = 16.
// Array after operations = {0, 2, 4, 9}.
// Operations count = 4.

public class HalveMinimumOperations {
    public static int minOperationsTohalveSum(int arr[]){

        int sum = 0;

        for(int num : arr){
            sum+=num;
        }

        System.out.println(sum);

        int target = sum / 2;
        System.out.println(target);
        int currSum = sum;
        System.out.println(sum);
        int Operations = 0;

        Arrays.sort(arr);

        for(int i=arr.length -1; i>=0; i--){
            if (currSum <= target) {
                break;
            }

            currSum -= arr[i] /2;
            arr[i] = arr[i] /2;
            Operations++;
        }

        return Operations;

    }

    static int minops(ArrayList<Integer> nums) {
        // Calculate the initial sum
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        
        // Create a max-heap (priority queue) to process the largest element first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Max-heap
        for (int i = 0; i < nums.size(); i++) {
            pq.add(nums.get(i));
        }
        
        double temp = sum; // Store the initial sum in temp
        int cnt = 0; // Counter for the number of operations
        
        // Keep halving the largest element until the sum is <= half of the initial sum
        while (temp > sum / 2) {
            int x = pq.poll(); // Get the largest element (max heap)
            temp -= x / 2.0; // Subtract half of the element's value from temp
            pq.add(x / 2); // Add the halved element back into the heap
            cnt++; // Increment the counter
        }
        
        return cnt; // Return the number of operations
    }

    public static void main(String []args){
        int arr[] = {1, 5, 8, 19};
        System.out.println(minOperationsTohalveSum(arr));

       
    }
}
