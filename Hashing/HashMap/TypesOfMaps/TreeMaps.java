package Hashing.HashMap.TypesOfMaps;
import java.util.*;


/* Tree Map - Self balancing tree
   Keys are Sorted 
   TC -> O(logn)
   It implements using red black trees
 */

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<String, Integer> hm = new TreeMap<>();
        hm.put("India", 100);
        hm.put("Pak", 150);
        hm.put("China", 50);
        System.out.println(hm);

    }
}
