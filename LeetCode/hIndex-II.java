public class hIndex-II {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int papers = n - mid; // number of papers with >= citations[mid]

            if (citations[mid] >= papers) {
                ans = papers;
                high = mid - 1; // try to find a larger H
            } else {
                low = mid + 1; // need more citations
            }
        }

        return ans;
    }
}


/*Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in non-descending order, return the researcher's h-index.
According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
You must write an algorithm that runs in logarithmic time. */

/*If the array is sorted ascending,
Pick a number h.
From index n-h to the last index n-1 (that’s h papers total),
all of those papers must have at least h citations. */