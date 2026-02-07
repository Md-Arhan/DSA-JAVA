public class MinPenalty {
    class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int prefix[] = new int[n];
        prefix[0] = customers.charAt(0) == 'Y' ? 1 : 0;

        for(int i=1; i<n; i++){
            if(customers.charAt(i) == 'Y'){
                prefix[i] = prefix[i-1] + 1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        int max = prefix[n-1];
        int min = max;
        int minIndex = 0;

        int penalty = 0;

        for(int i=0; i<n; i++){
            if(customers.charAt(i) == 'N'){
                penalty++;
            }

            if((max - prefix[i] + penalty) < min){
               min = (max - prefix[i] + penalty);
               minIndex = i+1;
            }
        }

        return minIndex;
    }
}
}
