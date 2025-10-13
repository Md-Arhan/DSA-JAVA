public class MinimumTimeToFillNSlots {
    public static void main(String[] args) {
        // Example inputs
        int N1 = 5, K1 = 5;
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(minTimeToFillSlots(N1, K1, arr1)); // Output: 1

        int N2 = 6, K2 = 2;
        int[] arr2 = {2, 6};
        System.out.println(minTimeToFillSlots(N2, K2, arr2)); // Output: 2
    }

    public static int minTimeToFillSlots(int N, int K, int[] arr) {
        // Queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        // Array to track visited (filled) slots
        boolean[] visited = new boolean[N + 1];

        // Add initially filled slots to the queue
        for (int slot : arr) {
            queue.offer(slot);
            visited[slot] = true;
        }

        // BFS variables
        int time = 0;

        // Directions to fill adjacent slots (-1 for left, +1 for right)
        int[] directions = {-1, 1};

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of slots to process in this time unit

            // Process all slots in the current level
            for (int i = 0; i < size; i++) {
                int currentSlot = queue.poll();

                // Try filling adjacent slots
                for (int dir : directions) {
                    int newSlot = currentSlot + dir;

                    // If the slot is within bounds and not visited
                    if (newSlot >= 1 && newSlot <= N && !visited[newSlot]) {
                        visited[newSlot] = true; // Mark as filled
                        queue.offer(newSlot); // Add to the queue for further processing
                    }
                }
            }

            // Increment time after processing the current level
            if (!queue.isEmpty()) {
                time++;
            }
        }

        return time;
    }
}
