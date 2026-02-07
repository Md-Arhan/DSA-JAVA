public class FindKSmallestSumPair{
        class Pair implements Comparable<Pair>{
        int val1;
        int val2;
        int i;
        int j;
        int evaluation;
        
        Pair(int val1, int val2, int i, int j){
            this.val1 = val1;
            this.val2 = val2;
            this.i = i;
            this.j = j;
            evaluation = val1 + val2; 
        }
        
        @Override 
        public int compareTo(Pair other){
            return this.evaluation - other.evaluation;
        }
    }
    
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        
        for(int i=0; i<Math.min(k, n); i++){
            pq.add(new Pair(arr1[i], arr2[0], i, 0));
        }
        
        while(!pq.isEmpty() && k-- > 0){
            Pair curr = pq.poll();
            int i = curr.i;
            int j = curr.j;
            
            ans.add(new ArrayList<>(Arrays.asList(curr.val1, curr.val2)));
            
            if(j+1 < m){
                pq.add(new Pair(arr1[i], arr2[j+1], i, j+1));
            }
        }
        
        return ans;
    }
}