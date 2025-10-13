package Hashing.HashMap.TypesOfMaps;
import java.util.*;

//Linked HashMap
/* Ordered Maps */

public class LinkedHashMaps {

    public static void main(String[] args) {
        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Pak", 150);
        lhm.put("Us", 50);

        System.out.println(lhm);

    }

}
