package Hashing.Extra;
import java.util.*;

public class mergefxn {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);

        // If key 1 exists, sum the old and new values (10 + 5 = 15)
        map.merge(1, 5, Integer::sum);
        
        // If key 3 doesn't exist, just insert it with value 30
        map.merge(3, 30, Integer::sum);

        System.out.println(map); // Output: {1=15, 2=20, 3=30}
    }
}
