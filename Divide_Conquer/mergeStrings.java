package Divide_Conquer;

public class mergeStrings {

    public static String[] mergeString(String str[], int si, int ei) {

        if (si >= ei) {
            String[] a = { str[si] };
            return a;
        }

        int mid = si + (ei - si) / 2;
        String arr1[] = mergeString(str, si, mid);
        String arr2[] = mergeString(str, mid + 1, ei);

        String arr3[] = merge(arr1, arr2);
        return arr3;

    }

    public static String[] merge(String arr1[], String arr2[]) {

        int m = arr1.length;
        int n = arr2.length;
        String temp[] = new String[m + n];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < m && j < n) {
            if (isAlphabetcallsmaller(arr1[i], arr2[j])) {
                temp[idx] = arr1[i];
                i++;
                idx++;
            } else {
                temp[idx++] = arr2[j++];
            }
        }

        while (i < m) {
            temp[idx] = arr1[i];
            i++;
            idx++;
        }

        while (j < n) {
            temp[idx++] = arr2[j++];
        }

        return temp;
    }

    public static boolean isAlphabetcallsmaller(String arr1, String arr2) {
        if (arr1.compareTo(arr2) < 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str[] = { "sun", "earth", "mars", "mercury" };
        String a[] = mergeString(str, 0, str.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
