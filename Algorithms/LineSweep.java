public class LineSweep {
    public int powerfulInteger(int[][] intervals, int k) {
        // code here
        
        List<int[]> aux = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++){
           aux.add(new int[]{intervals[i][0], +1});
           aux.add(new int[]{intervals[i][1], -1});
        }
        
        Collections.sort(aux, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        int count = 0;
        int ans = -1;
        
        for(int i=0; i<aux.size(); i++){
            int []temp = aux.get(i);
            
            if(count>=k){
                ans = temp[0];
            }
            
            count+=temp[1];
        }
        
        return ans;
        
    }
}
