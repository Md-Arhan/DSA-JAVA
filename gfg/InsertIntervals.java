package gfg;

import java.util.ArrayList;

public class InsertIntervals {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        int n = intervals.length;
        
        int i = 0;
        
        while(i<n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        
        int start = newInterval[0];
        int end = newInterval[1];
        while (i < n && intervals[i][0] <= end) {
          start = Math.min(start, intervals[i][0]);
          end = Math.max(end, intervals[i][1]);
          i++;
        }
        ans.add(new int[]{start, end});
        
        while(i<n){
            ans.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        return ans;
    }
}
