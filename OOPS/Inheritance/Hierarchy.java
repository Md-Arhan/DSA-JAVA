package Inheritance;

public class Hierarchy {
    public static void main(String[] args) {
        Bird crow = new Bird();
        crow.eat();
    }
}

// Base Class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breaths() {
        System.out.println("breath");
    }
}

class Mammals extends Animal {
    void walks() {
        System.out.println("walks");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("Swims");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("Fly");
    }
}
