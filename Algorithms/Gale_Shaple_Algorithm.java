class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        
        int pairmen[] = new int[n];
        int pairwomen[] = new int[n];
        int index[] = new int[n];\
        
        Arrays.fill(pairmen, -1);
        Arrays.fill(pairwomen, -1);
        
        int prefer[][] = new int[n][n];
        
        for(int w = 0; w < n; w++){
            for(int i = 0; i < n; i++){
                prefer[w][women[w][i]] = i;
            }
        }

        Queue<Integer> freeman = new LinkedList<>();

        for(int i = 0; i < n; i++){
            freeman.add(i);
        }

        while(!freeman.isEmpty()){
            int man = freeman.poll();

            int woman = men[man][index[man]++];

            if(pairwomen[woman] == -1){
                pairwomen[woman] = man;
                pairmen[man] = woman;
            }else{
                int curr = pairwomen[woman];

                if(prefer[woman][man] < prefer[woman][curr]){
                    pairwomen[woman] = man;
                    pairmen[man] = woman;

                    pairmen[curr] = -1;
                    freeman.add(curr);
                }else{
                    freeman.add(man);
                }
            }
        }

        return pairmen;
    }
}