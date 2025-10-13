// public class OOPS {

//     public static void main(String[] args) {
//         Pen p1 = new Pen();  // created a pen object called p1,
//         // p1.SetColor("Blue");
//         p1.color = "Yellow";    // new way
//         System.out.println(p1.color);
//         p1.SetTip(5);
//         System.out.println(p1.tip);
//     }
// }

// class Pen {
//     //Prop + functions
//     String color;
//     int tip;

//     void SetColor(String newColor){
//         color = newColor;
//     }

//     void SetTip(int newTip){
//         tip = newTip;
//     }
// }

// class Student {

//     String name;
//     int age;
//     float percentage; //cgpa

//     void calcPercentage(int phy, int che, int math){
//         percentage = (phy + che + math)/3;
//     }

// }



//Types of Inheritance




//Hybrid Inheritance
//Home Work

//Polymorphism


//Packages in java
//inbulit packages util.*;
//Userdefined package mypackage




//Solved Practice Question

//Q1

// class Student {
//     String name;
//     int marks;
// }

// public class OOPS {
//    public static void main(String[] args) {
//     Student s = new Student();
//     s.name = "Arhan";
//    }
// }

//Q2

// class Person{
//     String name;
//     int weight;
// }

// class Student extends Person{
//     int rollNo;
//     String schoolName;
// }

//Q3

//In java, there is no private and protectes classes are allowed

//Q4

// class Vehicle{
//     String name;
// }

// class Car extends Vehicle{
//    int no;
// }

// public class OOPS {

//     public static void main(String[] args) {
//         Vehicle v = new Car();          //v refernce varibale = Car extend reference
//         v.name= "arhan";
//     }
// }

//Q5

// class Vehicle{
//     void print(){
//         System.out.println("Base claa");
//     }
// }
// class Car extends Vehicle {
//   @Override              //First this will execute and then the parent class
//     void print(){
//         System.out.println("derived class");
//     } 

// }

// public class OOPS {

//     public static void main(String[] args) {
//         Vehicle obj = new Car();
//         obj.print();

//         Vehicle obj2 = new Vehicle();
//         obj2.print();

//     }

// }

//Q6

// class Vehicle{
//     void print(){
//         System.out.println("Base claa");
//     }
// }
// class Car extends Vehicle {
//     void print1(){
//         System.out.println("derived class");
//     } 

// }

// public class OOPS {

//     public static void main(String[] args) {
//         Vehicle obj1 = new Car();
//         obj1.print1();                //Error, obj1 can't recognize print 1, bcz of Creating Vehicle refernce variable 

//         Vehicle obj2 = new Vehicle();
//         obj2.print();

//     }

// }

//Q8

// public class OOPS {

//     public static void main(String[] args) {
//         System.out.println(Book.count);    //for static class we can directly acccess
//         Book b1 = new Book(100);
//         Book b2 = new Book(150);
//         System.out.println(Book.count);
//     }
// }

// class Book{
//     int price;
//     static int count;

//     Book(int price){
//         this.price = price;
//         count++;
//     }
// }

//Q9

// public class OOPS {

//     public static void main(String[] args) {
//         Test t = new Test();
//         t.set_marks(98);
//         System.out.println(Test.marks);
//     }
// }

// class Test{
//     static int marks;
//     void set_marks(int marks){
//         this.marks = marks;
//     }

// }

//Q10

// public class OOPS {

//     public static void main(String[] args) {
//         Test t = new Test();
//         t.changeB();
//         System.out.println(Test.a+Test.b);
//     }
// }

// class Test{
//     static int a = 10;
//     static int b;
//     static void changeB(){
//         b=a*3;
//     }
// }


//Assigment Question

// abstract class Car {
//     static {
//         System.out.print("1");
//     }

//     /*
//      * Instance blocks and instance variables in a class
//      * are initialized before the constructor runs to ensure
//      * that the object's state is fully prepared before the
//      * constructor logic begins.
//      */
//     public Car(String name) {
//         super();
//         System.out.print("2");
//     }

//     {
//         System.out.print("3");
//     }

// }

// public class BlueCar extends Car {
//     {
//         System.out.print("4");
//     }

//     public BlueCar() {
//         super("blue");
//         System.out.print("5");
//     }

// }

// public class OOPS {

//     public static void main(String[] args) {
//         new BlueCar();
//     }
// }


//Complex Number

// public class OOPS {

//     public static void main(String[] args) {
//         Complex c = new Complex(4, 5);
//         Complex d = new Complex(9, 4);

//         Complex e = Complex.add(c,d);
//         Complex f = Complex.add(c,d);
//         Complex g = Complex.add(c,d);
//         e.printComplex();
//         f.printComplex();
//         g.printComplex();

//     }
// }

// class Complex{
//     int real;
//     int imag;

//     Complex(int r, int i){
//         this.real = r;
//         this.imag = i;
//     }

//     static Complex add(Complex a, Complex b){
//         return new Complex((a.real +  b.real), (a.imag + b.imag));
//     }

//     static Complex diff(Complex a, Complex b){
//         return new Complex((a.real -  b.real), (a.imag - b.imag));
//     }

//     static Complex product(Complex a, Complex b){
//         return new Complex(((a.real *  b.real) - (a.imag * b.imag)),
//         ((a.real *  b.imag) + (a.imag * b.real)));
//     }
    
//     void printComplex(){
//         if(real ==0 && imag !=0){
//             System.out.println(imag + "1");
//         }
//         else if(imag == 0 && real !=0){
//             System.out.println(real);
//         }
//         else{
//             System.out.println(real + " + " + imag + " i ");
//         }
//     }
// }




// Sunday practice Session

// public class OOPS {

// public static int powerNum(int n, int a){
// int ans = 1;

// for(int i=0; i<n; i++){
// ans = ans * a;
// }
// return ans;
// }

// public static void main(String[] args) {
// int a = 2, n = 8;

// int ans = 1;

// while(n>0){
// if(n%2 == 1){
// ans = ans * a;
// }
// n = n/2;
// a = a*a;
// }
// System.out.println(ans);

// System.out.println(powerNum(3, 5));
// }
// }

// Copy Constructor

// class Student{
// String name;
// int rollNo;

// Student(String name, int rollNo){
// this.name = name;
// this.rollNo = rollNo;
// }

// Student(Student obj){
// this.name = obj.name;
// this.rollNo = obj.rollNo;
// }
// }

// public class OOPS {

// public static void main(String[] args) {
// // Student str1 = new Student("Arhan", 80);
// // System.out.println(str1.name);
// // System.out.println(str1.rollNo);
// // Student str2 = new Student(str1);
// // System.out.println(str2.name);
// // System.out.println(str2.rollNo);
// }

// }

//Shallow Copy

// class shallowCopy{
// int arr[];

// shallowCopy(int arr[]){
// this.arr = arr;
// }

// shallowCopy(shallowCopy obj){
// this.arr = obj.arr;
// }

// void display(){
// for(int i=0; i<arr.length; i++){
// System.out.print(arr[i] + " ");
// }
// System.out.println();
// }

// }

// public class OOPS {

// public static void main(String[] args) {

// int arr[] = {10, 20, 30};

// shallowCopy str1 = new shallowCopy(arr);

// shallowCopy str2 = new shallowCopy(str1);

// str1.display();
// str2.display();

// arr[0] = 11;
// arr[1] = 55;
// arr[2] = 77;

// str1.display();
// str2.display();

// }
// }

// Deep copy

// class Student
// {
// int arr[];

// Student( int arr[])
// {
// this.arr= new int[arr.length];

// for( int i=0;i< arr.length;i++)
// {
// this.arr[i]= arr[i];
// }

// }
// Student ( Student obj)
// {
// this.arr = new int[obj.arr.length];
// for(int i=0; i<arr.length; i++){
//     this.arr[i] = obj.arr[i];
// }
// }

// void display()
// {
// for( int i=0;i< arr.length;i++)
// {
// System.out.print( arr[i]+ " ");
// }
// System.out.println();
// }
// }
// public class OOPS {

// public static void main(String[] args)
// {
// int a[]= {10,20,30};

// Student st1= new Student( a );

// Student st2 = new Student( st1 );

// st1.display();
// st2.display();

// a[0]= 11;
// a[1]=55;
// a[2]=77;

// st1.display();
// st2.display();

// }
// }

