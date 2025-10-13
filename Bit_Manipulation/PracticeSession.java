

// Practice Session, Assignment Question

// public class bit {
// public static void main(String[] args) {
// // int x = 11;
// // // we have to set 6th bit of x
// // x = (x | (1 << 6));

// // // this should print 75
// // System.out.println(x);

// // int x = 9;
// // // we have to clear the 3rd bit

// // x = x & (~(1 << 3));
// // System.out.println(x);

// int a = 12;
// int b = 53;

// System.out.println("value of a: " + a);
// System.out.println("value of b: " + b);

// // swap these numbers
// // after swapping a = 53, b = 12;

// a = a ^ b;
// b = a ^ b;
// a = a ^ b;

// System.out.println("value of a: " + a);
// System.out.println("value of b: " + b);

// }
// }



//Adding 1 integer using Bit Manitpulation

public class PracticeSession{

    public static void main(String[]args) {
        int x=6;
        System.out.println(x+" + "+1+" is "+ -~x);
        x= -4;System.out.println(x+" + "+1+" is "+-~x); 
        x=0;System.out.println(x+" + "+1+" is "+-~x);
    }
}
