public class SumOfModes {
    class Pair implements Comparable<Pair>{
        int val;
        int freq;
        
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair other){
            if(this.freq != other.freq ){
                return other.freq - this.freq;
            }
            
            return this.val - other.val;
        }
    }
    
    public int sumOfModes(int[] arr, int k) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Pair> map = new HashMap<>();
        
        int n = arr.length;
        if(n < k){
            return 0;
        }
        
        for(int i=0; i<k; i++){
            if(map.containsKey(arr[i])){
               Pair old = map.get(arr[i]);
               pq.remove(old);
               old.freq++;
               pq.add(old);
            }else{
                Pair newPair = new Pair(arr[i], 1);
                pq.add(newPair);
                map.put(arr[i], newPair);
            }
        }
        
        int ans = pq.peek().val;
        
        for(int i=k; i<n; i++){
            int v = arr[i-k];
            Pair curr = map.get(v);
            pq.remove(curr);
            curr.freq--;
            
            if(curr.freq > 0){
                pq.add(curr);
            }else{
                map.remove(v);
            }
            
            if(map.containsKey(arr[i])){
               Pair old = map.get(arr[i]);
               pq.remove(old);
               old.freq++;
               pq.add(old);
            }else{
                Pair newPair = new Pair(arr[i], 1);
                pq.add(newPair);
                map.put(arr[i], newPair);
            }
            ans+=pq.peek().val;
        }
        
        return ans;
    }
}
