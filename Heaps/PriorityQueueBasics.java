import java.util.*;
public class PriorityQueueBasics {

    static class Student implements Comparable<Student>{  //OverRiding, Implementaion of parent class or Interface
        String name;
        int rank;

        Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){  //student object s2 is attribute
            return this.rank - s2.rank;
        }
    } 

    public static void main(String[] args) {
        PriorityQueue<Student> pqs = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        pqs.add(new Student("A", 4));       // -> O(logn)
        pqs.add(new Student("B",6));       // -> O(log n)
        pqs.add(new Student("C", 1));     // -> O(logn)
        pqs.add(new Student("D", 12));   // -> O(logn)
        
        pq.add(5);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pqs.isEmpty()){
            System.out.println(pqs.peek().name + "->" + pqs.peek().rank);  // O(1)
            pqs.remove();                                                // O(logn)
        }

        //Output : 1, 3, 4, 7   ||   c->1,  A->6, B->6, D->12;
    }
}


/*
Comparable Interface
Package: java.lang.Comparable
 * | Feature              | Description                                               |
| -------------------- | --------------------------------------------------------- |
| **Purpose**          | Used to define the *natural ordering* of objects.         |
| **Method**           | Must implement `compareTo(T o)` method.                   |
| **Location**         | Implemented by the class whose objects need to be sorted. |
| **Sorting logic**    | Written inside the class itself.                          |
| **Limitations**      | Can only have *one* compareTo implementation.             |
| **Example Use Case** | Sort a list of Students by their `rollNumber` naturally.  |

class Student implements Comparable<Student> {
    int rollNumber;

    public Student(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public int compareTo(Student other) {
        return this.rollNumber - other.rollNumber; // Ascending order
    }
}
 */


/*
 Comparator Interface
Package: java.util.Comparator
 * | Feature              | Description                                                       |
| -------------------- | ----------------------------------------------------------------- |
| **Purpose**          | Used to define *custom* ordering of objects.                      |
| **Method**           | Must implement `compare(T o1, T o2)` method.                      |
| **Location**         | Written outside the class, as a separate class or lambda.         |
| **Sorting logic**    | Can create *multiple* Comparators for different criteria.         |
| **Example Use Case** | Sort a list of Students by `name` or `age`, depending on context. |


class Student {
    String name;
    int age;

    // constructor, getters...
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.age - b.age;
    }
}

class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

 */




 /*
  * | Aspect                   | Comparable       | Comparator            |
| ------------------------ | ---------------- | --------------------- |
| Interface package        | `java.lang`      | `java.util`           |
| Method                   | `compareTo(T o)` | `compare(T o1, T o2)` |
| Sorting logic            | In the class     | Outside the class     |
| Number of sorting logics | One              | Many                  |
| Use case                 | Natural order    | Custom order          |

  */
