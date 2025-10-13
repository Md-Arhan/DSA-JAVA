package Inheritance;

public class basic {

    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();
        shark.breaths();
        shark.swin();
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

// Derived class or Subclass
class Fish extends Animal {
    int fins;

    void swin() {
        System.out.println("swims in water");
    }
}
