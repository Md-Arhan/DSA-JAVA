class Solution {

    public int getCutsize(int bars[], int n){
        int count = 1;  //consicutive bars
        int ans = 2; // if we cut 1 bar then we get 2 side

        Arrays.sort(bars);

        for(int i=1; i<bars.length; i++){
            if(bars[i] - bars[i-1]  == 1){
                count++;
                ans = Math.max(ans, count+1);
            }else{
                count = 1;
            }
        }

        return ans;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int x_cuts = getCutsize(hBars, n);
        int y_cuts = getCutsize(vBars, m);

        int side = Math.min(x_cuts, y_cuts);

        return side * side;
    }
}