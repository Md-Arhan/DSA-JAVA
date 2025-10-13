package Recursion;

public class TowerofHanoi {
    public static void toh(int n, int a, int c, int b) {

        if (n == 0) {
            return;
        }

        toh(n - 1, a, b, c);
        System.out.println("Moving " + n + "th disk from " + a + " to " + c);

        toh(n - 1, b, c, a);

    }

    public static void main(String[] args) {
        toh(3, 10, 30, 20);
    }
}


class TowerOfHanoi {
    // Recursive function to solve Tower of Hanoi
    static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary
        solveHanoi(n - 1, source, destination, auxiliary);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int numDisks = 3; // Change this to test with different numbers of disks
        System.out.println("Solution for " + numDisks + " disks:");
        solveHanoi(numDisks, 'A', 'B', 'C'); // A is source, B is auxiliary, C is destination
    }
}


/*Explanation:

1. Base Case: If there's only one disk, move it directly from source to destination.


2. Recursive Case:

Move n-1 disks from source to auxiliary.

Move the nth disk from source to destination.

Move the n-1 disks from auxiliary to destination.




Sample Output for 3 Disks:

Solution for 3 disks:
Move disk 1 from A to C
Move disk 2 from A to B
Move disk 1 from C to B
Move disk 3 from A to C
Move disk 1 from B to A
Move disk 2 from B to C
Move disk 1 from A to C

Let me know if you need any modifications!*/
