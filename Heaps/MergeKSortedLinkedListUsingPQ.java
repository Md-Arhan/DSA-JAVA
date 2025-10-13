import java.util.PriorityQueue;

public class MergeKSortedLinkedListUsingPQ {
     static class Sort implements Comparable<Sort> {
    
            int data;
            int i;
    
            Sort(int data, int i){
                this.data = data;
                this.i = i;
            }
    
            public int compareTo(Sort data2){
                return this.data - data2.data;
            }
        }
    
        public static void main(String []args){
            int list[][] = {
                {1, 4, 5}, 
                {1, 3, 4},
                {2, 6, 7}
            };
    
            PriorityQueue<Sort> pq = new PriorityQueue<>();
    
            for(int i=0; i<list.length; i++){
                for(int j=0; j<list[i].length; j++){             //he inner loop now uses list[i].length to iterate through the actual length of each row of the 2D array, instead of list.length, which would give the number of rows.
                    pq.add(new Sort(list[i][j], i));
                }
            }
    
            while (!pq.isEmpty()) {
                System.out.print(pq.peek().data + "->");
                pq.remove();
            }
    
        }
}


/*
 * TC:
Each insertion into a heap takes O(log N) time.
You insert N elements.
✅ Total Insertion Time = O(N log N)
You perform N removals.
Each removal takes O(log N).
✅ Total Removal Time = O(N log N)
 */