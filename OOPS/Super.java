public class Super {
    public static void main(String[] args) {
        Horse a = new Horse();
        System.out.println(a.color);
    }
}

class Animal {
    String color;
    Animal(){
        System.out.println("animal");
    }

}

class Horse extends Animal{
    Horse(){
        super.color = "brown";
        System.out.println("horse");
    }
}
