package BinarySearch;

import java.util.Arrays;

public class kokoEatingBananas {
    class Solution {

    public boolean isPossible(int k, int piles[], int h){
        int sum = 0;

        for(int i = 0; i<piles.length; i++){
            sum += (piles[i] + k -1) / k;
            if(sum > h){
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int minSpeed = 1;
        int maxSpeed =Arrays.stream(piles).max().getAsInt();

        int k = maxSpeed;

        while(minSpeed <= maxSpeed){
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if(isPossible(mid, piles, h)){
                k = mid;
                maxSpeed = mid - 1;
            }else{
                minSpeed = mid + 1;
            }
        }

        return k;

    }
}
}
