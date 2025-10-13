package Inheritance;

public class MultiLevelInheritance {

    public static void main(String[] args) {
        Dog dobDog = new Dog();
        dobDog.leg = 4;
        dobDog.breed = "doob";
        System.out.println(dobDog.breed);
        System.out.println(dobDog.leg);
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
    int leg;
}

class Dog extends Mammals {
    String breed;
}
