package Hashing.HashSets.Types;

import java.util.HashSet;

public class HashSetJCF {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        if (set.contains(2)) {
            System.out.println("Contains");
        }

        System.out.println(set.size());
        set.remove(2);
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());
    }
}
