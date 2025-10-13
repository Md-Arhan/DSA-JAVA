package Inheritance;

public class Polymorphism {

    //Method OverRiding
    public static void main(String []args){
        Deer d = new Deer();
        d.eat();
    }
}

class Animal{
    void eat() {
        System.out.println("Eat Anything");
    }

}

class Deer extends Animal{
   @Override
   void eat(){
    System.out.println("eats diff");
   }
    
//Method Overloading
public static void main(String []args){
    Calculate cal = new Calculate();
    System.out.println(cal.calc(1,2));
    System.out.println(cal.calc((float)1.1,5.1f));
}
}

class Calculate{
int calc(int a, int b){
    return a + b;
}

float calc(float a, float b){
    return a+b;
}
}
