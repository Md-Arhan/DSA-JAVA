package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectingN_Ropes {
    public static int  connectNropes(int arr[]){
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++){
            q.add(arr[i]);
        }

        int res = 0;
        while (q.size() > 1) {
            int frst = q.poll();
            int sec = q.poll();
            res += frst + sec;
            q.add(frst + sec);

        }

        return res;
    }

    public static void main(String[] args) {
        int n[] = {4, 3, 2, 6};
        Arrays.sort(n);
        int size = n.length;
        System.out.println(connectNropes(n));
    }
}
