package Hashing.Extra;

import java.util.Map;
import java.util.TreeMap;

class Merge2DArray {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // TreeMap use to store the data in ascending Order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 1; j < nums1[0].length; j++) {
                map.put(nums1[i][0], nums1[i][j]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 1; j < nums2[0].length; j++) {
                if (map.containsKey(nums2[i][0])) {
                    map.put(nums2[i][0], map.get(nums2[i][0]) + nums2[i][j]);
                } else {
                    map.put(nums2[i][0], nums2[i][j]);
                }
            }
        }

        // Rows will be size of mapKeys and 2 are the columns
        int aux[][] = new int[map.size()][2];
        int index = 0;

        // Map.Entry use to read all the keys in a HashMap
        for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
            aux[index][0] = maps.getKey();
            aux[index][1] = maps.getValue();
            index++;
        }

        return aux;

    }
}