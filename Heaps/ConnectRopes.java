import java.util.*;

public class ConnectRopes {
    
    public static void main(String[] args) {
        int arr[] = {4, 3, 2, 6};
        int n = arr.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        
        int cost = 0;

        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();

            cost += min + min2;
            pq.add(min+min2);
        }

        System.out.println(cost);
    }
}
