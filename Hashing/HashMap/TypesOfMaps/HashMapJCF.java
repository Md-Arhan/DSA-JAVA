package Hashing.HashMap.TypesOfMaps;

public class HashMapJCF {
    public static void main(String []args){

        //Create 
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // //Get O(1)
        int pop = hm.get("India");
        System.out.println(pop);

        System.out.println(hm.get("Indonesia"));   //If the value doesn't exist it will return null

        // //ContainsKey - O(1)
        System.out.println(hm.containsKey("India"));     //True
        System.out.println(hm.containsKey("Indonesia")); //False

        // //Remove - O(1)
        hm.remove("India");
        System.out.println(hm);

        // //Size
        System.out.println(hm.size());

        // //Is empty
        System.out.println(hm.isEmpty());

        // //Clear function
        hm.clear();
        System.out.println(hm.isEmpty());

        //Iterate
        //entrySet(), entry set use to give pairs of sets
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("key = " + k + ", value = " + hm.get(k) );
        }

    }
}
