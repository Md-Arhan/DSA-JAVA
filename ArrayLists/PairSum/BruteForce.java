package PairSum;

import java.util.ArrayList;

public class BruteForce {
    public static Boolean pairSum(ArrayList<Integer> list, int target) {
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

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(pairSum(list, 10));

    }
}
