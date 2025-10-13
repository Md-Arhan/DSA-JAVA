import java.util.PriorityQueue;

public class KthLargestInStream {
    public static void findKthLargest(int stream[], int k){
          // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Process each number in the stream
        for (int num : stream) {
            // Add the number to the heap
            minHeap.offer(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // Output the k-th largest element
            if (minHeap.size() < k) {
                System.out.print("_ ");
            } else {
                System.out.print(minHeap.peek() + " ");
            }
        }
    }

    
    public static void main(String[] args) {
        int stream[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int k = 3;

        findKthLargest(stream, k);
        //Output : _ _ 10 11 20 40 50 50
    }
}
