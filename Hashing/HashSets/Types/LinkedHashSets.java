package Hashing.HashSets.Types;

import java.util.*;

//LinkedHashSet
// Sorted in given manner

public class LinkedHashSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhii");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Delhii");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Bengaluru");

        System.out.println(lhs);

    }
}
