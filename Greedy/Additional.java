package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// public class Additional {
//     static class Person {
//         String name;
//         int age;

//         Person(String name, int age) {
//             this.name = name;
//             this.age = age;
//         }

//         @Override
//         public String toString() {
//             return name + " (" + age + ")";
//         }
//     }

//     public static void main(String[] args) {
//         List<Person> people = Arrays.asList(
//             new Person("Alice", 25),
//             new Person("Bob", 20),
//             new Person("Alice", 20),
//             new Person("Charlie", 25)
//         );

//         // Sort by name, then by age
//         people.sort(Comparator.comparing((Person p) -> p.name)
//                               .thenComparing(p -> p.age));

//         System.out.println("Sorted people: " + people);
//     }
// }

// public class Additional {

//     public static void main(String[] args) {
//         List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5);

//         // Using Comparator to sort
//         numbers.sort((a, b) -> Integer.compare(a, b));

//         System.out.println("Sorted list: " + numbers);
//     }
// }

public class Additional {

    class Person implements Comparable<Person> {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /*
         * This function compares 2 objects
         * A person object is passed as an argument
         * and returns negative integer, zero, or a positive integer
         * as this object is less than, equal to, or greater than the specified object.
         */

        @Override
        public int compareTo(Person person) {
            if (this.age == person.age) {
                return 0;
            } else {
                return (this.age < person.age) ? -1 : 1;
            }
        }

        @Override
        public String toString(){
            return this.name + ":" + this.age;
        }
    }
}