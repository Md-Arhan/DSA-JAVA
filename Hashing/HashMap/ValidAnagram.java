package Hashing.HashMap;

public class ValidAnagram {
     public static Boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for(int j=0; j<t.length(); j++){
            char ch = t.charAt(j);
            if (map.get(ch) != null) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) -1);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {  // O(n)
        String s = "heart";
        String t = "earth";

        System.out.println(validAnagram(s, t));
    }
}
