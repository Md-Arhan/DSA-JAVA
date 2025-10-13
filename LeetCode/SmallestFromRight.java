import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestFromRight {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        Arrays.fill(ans, 0);
        
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        mergeSort(pairs, 0, n - 1, ans);
        return Arrays.asList(ans);
    }

    private void mergeSort(int[][] arr, int si, int ei, Integer[] ans) {
        if (si >= ei) return;

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid, ans);
        mergeSort(arr, mid + 1, ei, ans);

        merge(arr, si, mid, ei, ans);
    }

    private void merge(int[][] arr, int si, int mid, int ei, Integer[] ans) {
        List<int[]> temp = new ArrayList<>();
        int i = si, j = mid + 1;
        int rightCount = 0;

        while(i<=mid && j<=ei){
            if(arr[i][0] > arr[j][0]){
                rightCount++;
                temp.add(arr[j]);
                j++;
            }else{
                ans[arr[i][1]]+=rightCount;
                temp.add(arr[i]);
                i++;
            }
        }

        while (i <= mid) {
            ans[arr[i][1]] += rightCount;
            temp.add(arr[i]);
            i++;
        }

        while (j <= ei) {
            temp.add(arr[j]);
            j++;
        }

        for (int k = si; k <= ei; k++) {
            arr[k] = temp.get(k - si);
        }
    }
}
