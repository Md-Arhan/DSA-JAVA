package Abstraction;

abstract class Animal {

    String color;

    Animal() {
        System.out.println("Animal Constructor called...");
    }

    void eat() {
        System.out.println("eats");
    }

    abstract void walk(); // Abstract method
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse Constructor called..");
    }

    void changeColor() {
        color = "dark brown";
    }

    void walk() { // Implementation of the abstract method  , //doesn't take any parameter, and implentaion in sub-class;
        System.out.println("Walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Constructor called");
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

public class AbstractDemo {  // Class name changed to follow conventions
    public static void main(String[] args) {  // Main method added
        
        // Horse hr = new Horse();
        // hr.eat();
        // hr.walk();
        // hr.changeColor();
        // System.out.println("Horse color: " + hr.color);

        // Chicken ch = new Chicken();
        // ch.eat();
        // ch.walk();

        // Mustang myHorse = new Mustang();
        // Animal --> Horse --> Mustang
    }
}