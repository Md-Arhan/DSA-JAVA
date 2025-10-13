package Strings;

import java.util.HashMap;
import java.util.Map;

public class TotalCharacterAfterStringTransformation {
    public int lengthAfterTransformations(String s, int t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t; i++){

            for(Map.Entry<Character, Integer> entry : new HashMap<>(map).entrySet()){
                char ch = entry.getKey();
                int n = entry.getValue();
                int count = entry.getValue();

                while(n>0){
                    if(ch == 'z'){
                        map.put('a', map.getOrDefault('a', 0) + 1);
                        map.put('b', map.getOrDefault('b', 0) + 1);
                    }else{
                        char forward = (char)(ch+1);
                        map.put(forward, map.getOrDefault(forward, 0) + 1);
                    }
                     n--;
                }

                map.put(ch, map.get(ch) - count);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
            }
        }

        int count = 0;
        for(Integer values : map.values()){
           count+=values;
        }

        return count;
    }

    public static void main(String[] args) {
         // Apply transformations t times
        for (int i = 0; i < t; i++) {
            HashMap<Character, Integer> temp = new HashMap<>();

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char ch = entry.getKey();
                int n = entry.getValue();

                // Transformation logic
                if (ch == 'z') {
                    temp.put('a', temp.getOrDefault('a', 0) + n);
                    temp.put('b', temp.getOrDefault('b', 0) + n);
                } else {
                    char forward = (char) (ch + 1);
                    temp.put(forward, temp.getOrDefault(forward, 0) + n);
                }
            }

            // Debugging: print map after each transformation
            System.out.println("Transformation " + (i + 1) + ": " + temp);

            map = temp; // Update the map for the next iteration
        }
    }
}
