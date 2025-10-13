# Functional Interface

Now Why Functional Interface is Important?

Because when there is only 1 work,
Java says:

"I can create the object automatically for you using a shortcut."

That shortcut is called a Lambda Expression.

Fan myFan = () -> System.out.println("Fan is rotating...");
myFan.rotate();

Functional Interface	Interface with ONLY ONE abstract method.
Purpose	So that we can use Lambda Expressions easily.

Real Java Examples:

Runnable (for threads) ➔ void run()
Callable (thread with return) ➔ V call()
Comparator (for sorting) ➔ int compare(T o1, T o2)

If you use @FunctionalInterface annotation,
then ONLY 1 abstract method is allowed.

# 2 Ways to Implement a Functional Interface:

1. Traditional Way (Normal Class)

@FunctionalInterface
interface MyInterface {
    void show();
}

class MyClass implements MyInterface {
    public void show() {
        System.out.println("Hello from MyClass!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyInterface obj = new MyClass();
        obj.show();
    }
}

2. Lambda Expression (Shortcut Way)

@FunctionalInterface
interface Printer {
    void print();
}

class PrinterImpl implements Printer {
    public void print() {
        System.out.println("Printing from PrinterImpl class...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Traditional Way
        Printer obj1 = new PrinterImpl();
        obj1.print();

        // Lambda Way
        Printer obj2 = () -> System.out.println("Printing from Lambda...");
        obj2.print();
    }
}

@FunctionalInterface
interface AddOperation {
    int add(int a, int b);
}

// Using Lambda Expression (Java's arrow function style)
AddOperation op = (a, b) -> a + b;

System.out.println(op.add(5, 10));



# How to convert in lambda

MathOperation add = new Addition();
System.out.println(add.operate(5, 10));  // Output: 15

MathOperation add = (a, b) -> a + b;
System.out.println(add.operate(5, 10));