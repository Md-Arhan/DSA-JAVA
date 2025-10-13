package Hashing.HashSets;

import java.util.HashSet;

public class IterationOnSets {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Bangalore");
        cities.add("Mumbai");
        cities.add("Delhi")

        //Iterator : This only works on Collections framework of java
        Iterator it = cities.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //Advanced looop
        for (String city : cities) {
            System.out.println(city);
        }
    }
}


/*
  Iterators in java
  Why use an Iterator?
  To loop through a collection without using an index.
  To safely remove elements from a collection while iterating.
  Works uniformly across different collection types (ArrayList, HashSet, etc.).

Summary
* Iterator is a universal tool to loop through collections.
* Use hasNext() + next() to loop.
* Use remove() to safely delete elements during iteration.
 */

/*
 import java.util.*;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            String fruit = it.next();
            System.out.println(fruit);
        }
    }
}

Output : 
Apple
Banana
Mango

 */