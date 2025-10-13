package PairSum2;

import java.util.ArrayList;

public class BruteForce {
    public static Boolean pairSum2(ArrayList<Integer> list, int target) {
        int n = list.size() - 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        System.out.println(pairSum2(list, 17));

    }
}
