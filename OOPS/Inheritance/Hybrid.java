package Inheritance;

class Animal {
    // Base class
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Derived class 1 (Single inheritance)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Derived class 2 (Hierarchical inheritance)
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}

// Interface (to achieve multiple inheritance)
interface Swimmable {
    void swim();
}

// Hybrid inheritance (Dog + Swimmable)
class Labrador extends Dog implements Swimmable {
    @Override
    public void swim() {
        System.out.println("Labrador is swimming");
    }
}

// Main class
public class Hybrid {
    public static void main(String[] args) {
        Labrador labrador = new Labrador();
        labrador.eat(); // From Animal class
        labrador.bark(); // From Dog class
        labrador.swim(); // From Swimmable interface

        Cat cat = new Cat();
        cat.eat(); // From Animal class
        cat.meow(); // From Cat class
    }
}
