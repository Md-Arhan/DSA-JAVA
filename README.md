#  What does static mean?
A static method belongs to the class, not to a specific instance of the class. That means:

You can call it without creating an object of the class.

It cannot access non-static (instance) variables or methods directly.

It’s often used for utility/helper methods or when instance state is not needed.

* !Important -> Benefits of making a function static:
1. No need to create an object
You can call the method directly using the class name:

MyClass.myStaticMethod();
This saves memory and is more efficient when you don't need object-specific data.

2. Better for utility/helper functions
If a method does not depend on instance variables (like head, val, etc.), making it static is good practice.

Example:

public static int add(int a, int b) {
    return a + b;
}

* What this means:
When we say:

"If a method does not depend on instance variables (like head, val, etc.), making it static is good practice."

We mean:

If your method only works with the parameters passed to it, and
It does not need to use this or any object-specific variables,
...then you should make it static.

Example explained:
public static int add(int a, int b) {
    return a + b;
}
This add method:

Takes two numbers a and b.
Returns their sum.
Doesn't use any class fields or object state.
So it can (and should) be marked as static, because there's no need to create an object just to use this method.

* Compare with non-static:

public class Calculator {
    public int x;

    public int addToX(int a) {
        return a + this.x; // uses instance variable x
    }
}

Here, addToX() depends on x, which is tied to an instance of the class. So this method must be non-static.

# real world Example

 What’s the Core Difference?
Type	Belongs To	Accessed Using	Exists Without Object?
static	Class	ClassName.staticThing	✅ Yes
non-static	Object	object.nonStaticThing	❌ No

Think of a Class Like a Blueprint
Example:
Let’s say you have a class called Car.

class Car {
    static int totalCars = 0; // shared across all cars (class-level)
    String color;             // each car has its own color (object-level)

    Car(String color) {
        this.color = color;
        totalCars++; // count of all cars created
    }

    void showColor() {
        System.out.println("Color: " + color); // non-static method accessing non-static variable
    }

    static void showTotalCars() {
        System.out.println("Total cars: " + totalCars); // static method accessing static variable
    }
}
📦 Static vs Non-Static in Code
🚗 Creating Cars:

Car car1 = new Car("Red");
Car car2 = new Car("Blue");
Now:

car1.color → "Red"

car2.color → "Blue"

Car.totalCars → 2 (shared, static)

🔄 Differences in Method Access
✅ Non-static Method: Needs an object

car1.showColor();   // Works ✅
Car.showColor();    // ❌ Error – needs an object
✅ Static Method: Belongs to the class

Car.showTotalCars(); // ✅ Works without any object
car1.showTotalCars(); // Also works but not preferred

#  When to Use static vs non-static — Simple Rule
✅ Use static when:
You're writing a single-use class (like in a small example or utility class).
You don’t need multiple objects (no instance-specific data).
Your logic is shared across all instances (e.g., main(), counters, helpers).

🔄 Use non-static when:
You need to create multiple objects, each with its own data.
You're writing real-world OOP code, like users, accounts, cars, etc.
You want to follow good design and scalability.

# logn

The logarithmic time complexity, commonly written as O(log n), describes an algorithm that reduces the size of the problem in each step, typically by half. This is very efficient for large input sizes.

What does O(log n) mean?
It means the number of steps grows logarithmically in relation to the input size.

Example: If input size is n, and the algorithm halves the input each time, the number of steps will be about log₂(n).

If you want an algorithm to have O(log n) time complexity, it must repeatedly divide the problem into halves (or another fraction) at each step.

* Summary
O(log n) means the algorithm becomes faster as it reduces the input size exponentially.

Logarithmic algorithms are highly efficient, especially for large data.

Most commonly appear in search algorithms, tree data structures, and some divide & conquer strategies.


# log2(n) increases

When n = 1, log₂(1) = 0

n = 2, log₂(2) = 1

n = 4, log₂(4) = 2

n = 8, log₂(8) = 3

n = 16, log₂(16) = 4

n = 32, log₂(32) = 5

n = 64, log₂(64) = 6

n = 128, log₂(128) = 7

n = 256, log₂(256) = 8

n = 512, log₂(512) = 9

n = 1024, log₂(1024) = 10

n = 2048, log₂(2048) = 11

n = 4096, log₂(4096) = 12

n = 8192, log₂(8192) = 13

n = 16384, log₂(16384) = 14

n = 32768, log₂(32768) = 15

n = 65536, log₂(65536) = 16

n = 131072, log₂(131072) = 17

n = 262144, log₂(262144) = 18

n = 524288, log₂(524288) = 19

n = 1,048,576, log₂(1,048,576) = 20





# | Class         | Method              | Return Type     | Modifies the object? | Can chain? |
| ------------- | ------------------- | --------------- | -------------------- | ---------- |
| ArrayList     | `add()`             | `boolean`       | ✅ Yes                | ❌ No       |
| StringBuilder | `append()`          | `StringBuilder` | ✅ Yes                | ✅ Yes      |
| Stack         | `push()`            | `E`             | ✅ Yes                | ❌ No       |
| Stack         | `pop()`             | `E`             | ✅ Yes                | ❌ No       |
| Queue         | `add()` / `offer()` | `boolean`       | ✅ Yes                | ❌ No       |
| Queue         | `poll()` / `peek()` | `E`             | ✅ Yes                | ❌ No       |
# DSA
# DSA
# DSA-JAVA
