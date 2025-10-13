package Test;

// import java.util.*;

// import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

// public class JavaBasics{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// long input = sc.nextLong();
// System.out.println(input);
// }
// }

// public class JavaBasics{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// float radius = sc.nextFloat();
// float area = 22/7f*radius*radius;
// System.out.println(area);
// }
// }

// fibonacci series

// public class JavaBasics {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the Number tp find fibonacci:");
//         int num = sc.nextInt();
//         sc.close();
//         int f1 = 0,
//                 f2 = 1,
//                 fn;
//         for (int i = 2; i <= num; i++) {
//             fn = f1 + f2;
//             f1 = f2;
//             f2 = fn;
//             System.out.println(fn);
//         }
//     }
// }

// Amstrong number

// public class JavaBasics {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter a number to find the Amstrong Number:");
// int num = sc.nextInt();
// sc.close();

// int ComparisonNumber = num;
// int SumofDigit = 0;

// while(num != 0){
// int dig = num%10;
// num /=10;
// // int n = dig;
// // System.out.println(n);
// SumofDigit += (dig*dig*dig);
// }

// if(SumofDigit == ComparisonNumber){
// System.out.println("Yes, It's a Amstrong number");
// }else{
// System.out.println("No, It's not a Amstrong number");
// }
// }
// }

// public class JavaBasics{
// public static void main(String args[]){
// float a = 12.99f;
// double b =100.99;
// System.out.println((a));
// System.out.println((b));
// }
// }

// average 0of 3 numbers

// public class JavaBasics {
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the Number:");
// int num1 = sc.nextInt();
// System.out.println("Enter the Number:");
// int num2 = sc.nextInt();
// System.out.println("Enter the Number:");
// int num3 = sc.nextInt();
// sc.close();

// int avg = (num1+num2+num3)/3;

// System.out.println(avg);

// }
// }

// In a program, input the side of a square.You have to output the area of the
// square.

// public class JavaBasics {
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the Number:");
// int side = sc.nextInt();
// sc.close();

// int area = side*side;

// System.out.println(area);

// }
// }

// Enter the cost of three items

// public class JavaBasics {
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the Number:");
// float Pencil = sc.nextFloat();
// System.out.println("Enter the Number:");
// float Eraser = sc.nextFloat();
// System.out.println("Enter the Number");
// float Pen = sc.nextFloat();
// sc.close();

// System.out.println(Pencil);
// System.out.println(Pen);
// System.out.println(Eraser);

// float Total = Pen+Pencil+Eraser;

// System.out.println("Total cost of the bill is:"+ Total);

// //18% GST

// float WithGST = Total + (0.18f * Total);

// System.out.println(WithGST);

// }
// }

// public class JavaBasics {
// public static void main(String args[]){
// int $=24; //it will not give any error bcz in java identifiers we can use '$'
// and '_' as the first symbol for the variable
// }
// }

// public class Test {
// public static void main(String[] args){
// int x = 2, y = 5;
// int exp1 = (x * y / x);
// int exp2 = (x * (y / x));
// System.out.println(exp1);
// System.out.println(exp2);
// }
// }

// public class Test {
// public static void main(String[] args){
// int x, y, z;
// x = y = z = 2;
// x += y;
// y -= z;
// z /= (x + y);
// System.out.println(x + " " + y + " " + z);
// }
// }

// public class Test {
// public static void main(String[] args){
// int x = 9, y = 12;
// int a = 2, b = 4, c = 6;
// int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
// System.out.println(exp);
// }
// }

// Tax calculator

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter Your LPA:");
// int income = sc.nextInt();
// int tax;

// if(income < 500000){
// tax = 0;
// }else if(income >=400000 && income < 1000000){
// tax = (int) (income * 0.2);
// }else{
// tax = (int) (income * 0.3);
// }
// System.out.println("Your Tax is:" + tax);
// }
// }

// Print the largest of three number

// public class Test{
// public static void main(String args[]){
// int a = 1;
// int b = 3;
// int c = 6;

// if ((a>=b) && (a>=c)){
// System.out.println(a);
// }else if((b>=a) && (b>=c)){
// System.out.println(b);
// }else{
// System.out.println(c);
// }

// }
// }

// Ternary operator

// public class Test{
// public static void main(String args[]){
// int a = 1;
// int b = 3;

// int larger = (a>b)?a:b;
// System.out.println(larger);

// int number = 15;
// String type = (number%2==0)?"even":"odd";
// System.out.println(type);
// }
// }

// check if a student will pass or fail

// public class Test{
// public static void main(String args[]){
// float marks = 66.6f;

// String result = (marks>=33)? "pass" : "fail";

// System.out.println(result);

// }
// }

// Switch Staments

// public class Test{
// public static void main(String args[]){
// int number = 5;
// switch (number) {
// case 1: System.out.println("hello");
// break;
// case 2: System.out.println("world");
// break;
// default: System.out.println("default");
// break;
// }

// }
// }

// calculator

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter First Number");
// int a = sc.nextInt();
// System.out.println("Enter the operator");
// char operator = sc.next().charAt(0);
// System.out.println("Enter Second Number");
// int b = sc.nextInt();

// switch (operator) {
// case '+':
// System.out.println(a+b);
// break;
// case '-':
// System.out.println(a-b);
// break;
// case '*':
// System.out.println(a*b);
// break;
// case '/':
// System.out.println(a/b);
// break;
// case '%':
// System.out.println(a%b);
// break;

// default: System.out.println("Not to advance");
// break;
// }

// }
// }

// Home Work questions

// 1.

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// if(num>0){
// System.out.println("positive number");
// }else{
// System.out.println("Neagative");
// }

// }
// }

/*
 * 2. Finish the following code so that it prints You have a fever if your
 * temperature is above 100 and otherwise prints You don't have a fever.
 */

// public class Test{
// public static void main(String args[]){
// double temp = 103.5;
// if(temp > 100){
// System.out.println("fever");
// }else{
// System.out.println("I don't have a fever");
// }
// }
// }

// 3.

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// if(num>0){
// System.out.println("positive number");
// }else{
// System.out.println("Neagative");
// }

// }
// }

// 3.Write a Javaprogram to input week number (1-7) and print day of week name
// using switch case

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// switch (num) {
// case 1:
// System.out.println("Monday");
// break;
// case 2:
// System.out.println("Tuesday");
// break;
// case 3:
// System.out.println("Wednesday");
// break;
// case 4:
// System.out.println("Thursday");
// break;
// case 5:
// System.out.println("Friday");
// break;
// case 6:
// System.out.println("Saturday");
// break;

// default:System.out.println("Default");
// break;
// }
// }
// }

// 4.

// public class Test{
// public static void main(String args[]){

// int a=63, b=36;
// boolean x= (a<b)?true:false;
// int y= (a>b)?a:b;
// }
// }

// 5.

// public class Test{
// public static void main(String args[]){
// Scanner sc = new Scanner(System.in);
// System.out.println("Input a year");
// int year = sc.nextInt();

// boolean x = (year % 4 ==0);
// boolean y = (year % 100 != 0);
// boolean z = (year % 100 == 0) && (year % 400 == 0);

// if (x && (y||z)){
// System.out.println(year + "is a leap year");
// }else{
// System.out.println(year + "is not a leap year");
// }
// }
// }

// factorial of n

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// sc.close();
// int fact = 1;
// for (int i = 1; i <= num; i++) {
// fact = fact * i;
// }
// System.out.println(fact);
// }
// }

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// sc.close();
// int fact = 0;
// for (int i = 1; i <= num; i++) {
// fact = fact + i;
// }
// System.out.println(fact);
// }
// }

//

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// System.out.print("Enter a number: ");
// int num = sc.nextInt();
// sc.close();

// int val = 1; // Initialize sum as 0
// int sum = 0; // Initialize forward counter

// while(val<=num){
// sum = sum + val;
// val =val + 1;
// }

// System.out.println(sum);
// }
// }

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// System.out.print("Enter a number: ");
// int num = sc.nextInt();

// int val = 1; // Initialize sum as 0
// int sum = 1; // Initialize forward counter

// while(val<=num){
// sum = sum * val;
// val =val + 1;
// }

// System.out.println(sum);
// }
// }

// Loops
// While loop

// public class Test {
// public static void main(String args[]) {
// int counter = 0;

// while(counter<100){
// System.out.println("hello world");
// counter++;
// }
// System.out.println("Printed hello world 100 times");
// }
// }

// print number from 1 to 10

// public class Test {
// public static void main(String args[]) {
// int counter = 1;

// while(counter<=10){
// System.out.print(counter + " ");
// counter++;
// }
// }
// }

// Print number from 1 to n

// public class Test {
// public static void main(String args[]) {

// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// int counter = 1;
// sc.close();

// while(counter<=n){
// System.out.print(counter + " ");
// counter++;
// }
// }
// }

// for loop

// public class Test {
// public static void main(String args[]) {

// for (int i = 0; i<=5000; i++){
// System.out.println("hello world");
// }
// }
// }

// print square pattern

// public class Test {
// public static void main(String args[]) {

// // int counter = 4;
// // int i =1;

// // for( int i=1; i<=counter; i++){
// // System.out.println("****");
// // }

// // while(i<=counter){
// // System.out.println("****");
// // i++;
// // }

// }
// }

// do while loop

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// sc.close();

// do{
// System.out.println("hello");
// n++;
// }while(n<=10);

// }
// }

// break statement

// public class Test {
// public static void main(String args[]) {

// for(int i = 1; i<=5; i++){
// if(i==3) break;
// System.out.println(i);
// }

// }
// }

// break prog

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);

// do{
// int n = sc.nextInt();
// if(n % 10 ==0){
// break;
// }
// System.out.println(n);

// }while(true);
// }
// }

// continue statement

// public class Test {
// public static void main(String args[]) {

// for(int i = 1; i<=5; i++){
// if(i==3) continue;
// System.out.println(i);
// }

// }
// }

// continue program

// public class Test {
// public static void main(String args[]) {
// Scanner sc = new Scanner(System.in);

// do{
// System.out.println("Enter your number");
// int n = sc.nextInt();
// sc.close();
// if(n % 10 ==0){
// continue;
// }
// System.out.println(n);

// }while(true);

// }
// }

// Practice Questions

// public class Test {

// public static void main(String[] args) {
// for(int i=0; i<=5; i++){
// System.out.println("hello");
// i +=2;
// }
// }
// }

// Write a program that reads a set of integers, and then prints the sum of even
// and odd integers

// public class Test {

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);

// int number;
// int choice;
// int evenSum = 0;
// int oddSum = 0;

// do{
// System.out.println("Enter the number");
// number = sc.nextInt();

// if(number%2==0){
// evenSum +=number;
// }else{
// oddSum +=number;
// }

// System.out.println("Do you want to continue? Press 1 for yes or 0 for no");

// choice = sc.nextInt();

// }while(choice==1);

// System.out.println("Sum of even numbers:"+ evenSum);
// System.out.println("Sum of odd numbers:"+ oddSum);
// }
// }

// Multiplication table

// public class Test {

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the number to print the multiplication Table");
// int n= sc.nextInt();

// for(int i=1; i<=10; i++){
// System.out.println(n + "x" + i + "=" + n*i);
// }

// }
// }

// Even and odd number

// public class Test {

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the Number");
// int num = sc.nextInt();

// for(int i=1; i<=num; i++){

// if(i%2==0){
// System.out.println( i + " is an even number");
// }else{
// System.out.println( i + " is an odd number");
// }
// }
// }
// }

// Functions

// public class Test {

// public static void printHello() {
// System.out.println("Hello World");
// System.out.println("Hello World");
// System.out.println("Hello World");
// // return 3;
// }
// public static void main(String[] args) {
// printHello();
// }
// }

// Function with parameter

// public class Test {

// public static int calculate(int a, int b) {
// int sum = a + b;
// return sum;
// }
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int a = sc.nextInt();
// int b = sc.nextInt();
// int sum = calculate(a,b);
// System.out.println(sum);
// }
// }

// practice

// public class Test {

// public static void calculate(int a, int b) {
// int sum = a + b;
// System.out.println(sum);
// }
// public static void main(String[] args) {
// int a = 10;
// int b = 20;
// calculate(a,b);
// }
// }

// Swaping

// public class Test {

// public static void main(String[] args) {
// int a = 10;
// int b = 5;

// int temp = a;
// a = b;
// b = temp;

// System.out.println("a = " + a);
// System.out.println("b = " + b);

// }
// }

// Swap in function

// public class Test {

// public static void calculate(int a, int b) {

// int temp = a;
// a = b;
// b = temp;

// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int a = sc.nextInt();
// int b = sc.nextInt();
// calculate(a, b);
// System.out.println("a = " + a);
// System.out.println("b = " + b);
// }
// }

// Find Product of a&b

// public class Test {

// public static int multiply(int a, int b) {
// int sum = a * b;
// return sum;
// }
// public static void main(String[] args) {
// int a = 3;
// int b = 5;
// int res = multiply(a,b);
// System.out.println(res);
// res = multiply(25, 60);
// System.out.println(res);
// }
// }

// factorial of n + Binomial Co-efficeint

// public class Test {

// public static int factorial(int n, int b) {
// for(int i=n; i>0; i--){
// b = b*i;
// }
// return b;
// }

// public static int binCoeff(int n, int r){
// int fact_n = factorial(n, 1);
// int fact_r = factorial(r, 1);
// int fact_nmr = factorial(n-r, 1);

// int binCoeff = fact_n / (fact_r*fact_nmr);
// return binCoeff;
// }
// public static void main(String[] args) {
// // Scanner sc = new Scanner(System.in);
// // int n = sc.nextInt();
// // int fact = 1;
// // int value = factorial(n, fact);
// // System.out.println(value);
// System.out.println(binCoeff(5, 2));
// }
// }

// Function Overloading

// public class Test {

// public static int sum(float a, float b) {
// int A = (int) a;
// int B = (int) b;
// int sum = A+B;
// return sum;
// }

// public static int sum(int a, int b, int c) {
// return a+b+c;
// }
// public static void main(String[] args) {
// System.out.println(sum(5,2));
// System.out.println(sum(5,2,5));
// }
// }

// Function Overloading using data type

// public class Test {

// public static int sum(int a, int b) {
// return a+b;
// }

// public static float sum(float a, float b) {
// return a+b;
// }
// public static void main(String[] args) {
// System.out.println(sum(5,2));
// System.out.println(sum(5.2f,2.6f));
// }
// }

// Check a number is prime or not

// public class Test {

// public static void isPrime(int n) {
// if (n == 2) {
// System.out.println(n + " Prime Number");
// } else {
// boolean isTrue = true;
// for (int i = 2; i <= n - 1; i++) {
// if (n % i == 0) {
// isTrue = false;
// }
// }
// if (isTrue == true) {
// System.out.println(n + " prime Number");
// } else {
// System.out.println(n + " is not a prime number");
// }
// }
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the number");
// int n = sc.nextInt();
// isPrime(n);
// }
// }

// Write a java method to compute the average of three numbers

// public class Test {

// public static int average(int a, int b, int c){
// return (a + b + c) / 3;
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the First Number:");
// int Num1 = sc.nextInt();

// System.out.println("Enter the sec Number:");
// int Num2 = sc.nextInt();

// System.out.println("Enter the third Number:");
// int Num3 = sc.nextInt();

// int result = average(Num1,Num2,Num3);
// System.out.println(result);

// }
// }

// isEven or not

// public class Test {

// public static boolean isEven(int n) {
// boolean isEven = true;
// if(n % 2 == 0){
// isEven = true;
// }else{
// isEven = false;
// }
// return isEven;
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the Number:");
// int Num1 = sc.nextInt();

// System.out.println(isEven(Num1));

// }
// }

// Palindrome

// public class Test {

// public static boolean isPalindrome(int n) {
// int Palindrome = n;
// int remainder = 0;

// while (n > 0){
// int reverse = n %10;
// remainder = remainder * 10 + reverse;
// n = n/10;
// }

// if(Palindrome == remainder){
// return true;
// }else{
// return false;
// }

// }

// public static void main(String[] args) {

// Scanner sc = new Scanner(System.in);
// System.out.println("Enter the number");
// int num1 = sc.nextInt();

// if (isPalindrome(num1)) {
// System.out.println(num1 + " is a palindrome.");
// } else {
// System.out.println(num1 + " is not a palindrome.");
// }
// }
// }

// Math classes (max, min, pow, sqrt, pow, avg, abs)

// public class Test {
// public static void main(String[] args){
// int x = 28;
// int y = 4;

// System.out.println(Math.min(x, y));
// System.out.println(Math.max(x, y));
// System.out.println(Math.pow(x, y));
// System.out.println((int)Math.sqrt(x));
// System.out.println((int)Math.log(x));
// System.out.println(Math.abs(x));
// }
// }

// Array

// Assignment Question

// public class Test {

// public static boolean question1(int numbers[]) {

// // 1.
// // for(int i=0; i<numbers.length; i++){
// // for(int j=i+1; j<numbers.length; j++){
// // if(numbers[i] == numbers[j]){
// // return true;
// // }
// // }
// // }
// // return false;

// // 2.
// HashSet<Integer> set = new HashSet<>();
// for (int i = 0; i < numbers.length; i++) {
// if (set.contains(numbers[i])) {
// return true;
// } else {
// set.add(numbers[i]);
// }
// }
// return false;
// }

// public static int question3(int numbers[]) {
// int maxValue = 0;

// for (int i = 0; i < numbers.length; i++) {
// int buyPrice = numbers[1];
// int sellingPrice = numbers[4];
// if (buyPrice < sellingPrice) {
// int profit = sellingPrice - buyPrice;
// // System.out.println(profit);
// maxValue = Math.max(maxValue, profit);
// }
// }
// return maxValue;

// }

// public static int question4(int height[]) {
// // Left max boundry
// int leftMax[] = new int[height.length];
// leftMax[0] = height[0];

// for (int i = 1; i < height.length; i++) {
// leftMax[i] = Math.max(height[i], leftMax[i - 1]);
// System.out.print(leftMax[i] + " ");
// }
// System.out.println();

// // Right max boundry

// int rightMax[] = new int[height.length];
// rightMax[height.length - 1] = height[height.length - 1];

// for (int i = height.length - 2; i >= 0; i--) {
// rightMax[i] = Math.max(height[i], rightMax[i + 1]);
// System.out.print(rightMax[i] + " ");
// }
// System.out.println();

// // loop
// int trappedWater = 0;
// for (int i = 0; i < height.length; i++) {
// // Water level = min(leftMax Boundry, rightMax Boundry)
// int waterLevel = Math.min(rightMax[i], leftMax[i]);

// // trappedWater = (waterLevel - height[i]);
// trappedWater = trappedWater + (waterLevel - height[i]);

// }

// return trappedWater;
// }

// public static Set<List<Integer>> question5(int nums[]) {
// Set<List<Integer>> result = new HashSet<>(); // Use a HashSet to avoid
// duplicates

// // Iterate through all combinations of triplets
// for (int i = 0; i < nums.length; i++) {
// for (int j = i + 1; j < nums.length; j++) {
// for (int k = j + 1; k < nums.length; k++) {
// // Check if the triplet sums to zero
// if (nums[i] + nums[j] + nums[k] == 0) {
// // Create a triplet
// List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
// Collections.sort(triplet); // Sort to ensure the order for uniqueness
// result.add(triplet); // Add to HashSet
// }
// }
// }
// }
// return result; // Return the unique triplets
// }

// public static void main(String[] args) {

// // Question no.1
// // int numbers[] = {1, 2, 3,1};

// // boolean res = question1(numbers);
// // if(res){
// // System.out.println("Yes");
// // }else{
// // System.out.println("No");
// // }

// // Question no.3

// // int numbers[] = { 7, 6, 4, 3, 1 };

// // System.out.println(question3(numbers));

// // Question no.4

// // int height[] = {4, 2, 0, 3, 2, 5};

// // System.out.println(question4(height));

// //Question no.5

// int numbers[] = {-1, 0, 1, 2, -1, -4};

// // Call the threeSum method.
// Set<List<Integer>> triplets = question5(numbers);

// // Print the results.
// System.out.println("Unique triplets that sum to zero: " + triplets);

// }
// }

// Sorting Algorithm

// 2D Array

// Spiral Matrix

// Assignment QUestions

// Question 1

// public class Test {

// public static boolean prinNum(int num[][]){

// int target = 7;

// for(int i=0; i<num.length; i++){
// for(int j=0; j<num[0].length; j++){
// if(num[i][j] == target){
// return true;
// }
// }
// }
// return false;

// }

// public static void print(int num[][]){
// int target = 7;
// int count = 0;

// for(int i=0; i<num.length; i++){
// for(int j=0; j<num[0].length; j++){
// if(num[i][j] == target){
// // System.out.println( "the target is at " + i + "," + j);
// count++;
// }
// }
// }
// System.out.println(count);

// }

// public static void main(String[] args) {
// int num[][] = {
// {
// 4,7,8
// },
// {
// 8,8,7
// }
// };
// print(num);
// }
// }

// Question 2

// public class Test {

// public static int sumOfNum(int num[][]){
// int sum = 0;

// for(int j=0; j<num[0].length; j++){
// sum+= num[1][j];
// }

// return sum;
// }

// public static void main(String[] args) {
// int num[][] = {
// {1,4,9},
// {11,4,3},
// {2,2,3}
// };
// System.out.println(sumOfNum(num));
// }
// }

// Question 3
// Tranpose Matrix

// Pending

// practice Session (Sunday)

// public int[][] transpose(int[][] matrix) {
// int n = matrix.length;

// int curr_r = 0;
// int curr_c = 0;

// while(curr_r<n){
// int i = curr_r;

// for(int j = curr_c; j<n; j++){
// // swap row, col wit
// int temp = matrix[i][j];

// matrix[i][j] = matrix[j][i];
// matrix[j][i] = temp;
// }
// curr_r++;
// curr_c++;
// }

// return matrix;
// }

// public static void printSpiral(int[][] matrix){
// int n = matrix.length;
// int m = matrix[0].length;

// int sr = 0, sc = 0, er = n-1, ec = m-1;
// int row,col;

// while(sr<=er && sc<=ec){
// // print starting col from sr to er
// col = sc;
// for(row=sr; row<=er && sc<=ec; row++){
// System.out.print(matrix[row][col] + ", ");
// }
// sc++;

// // print ending row from sc to ec
// row = er;
// for(col = sc; col<=ec && sr<=er; col++){
// System.out.print(matrix[row][col] + ", ");
// }
// er--;

// // print ending col from er to sr
// col = ec;
// for(row=er; row>=sr && sr<=er && sc<=ec; row--){
// System.out.print(matrix[row][col] + ", ");
// }
// ec--;

// // print starting row from ec to sc
// row = sr;
// for(col = ec; col>=sc && sr<=er && sc<=ec; col--){
// System.out.print(matrix[row][col] + ", ");
// }
// sr++;

// System.out.println();
// }
// }

// public static void main(String[] args){
// int[][] arr = {{1,6,11,14,21}, {2,7,12,15,25}, {3,8,13,16,22},
// {4,9,17,19,24}, {5,10,20,18,23}};

// printSpiral(arr);
// }

// public static void printArr(int numbers[]){
// for(int i=0; i<numbers.length; i++){
// System.out.println(numbers[i]);
// }
// System.out.println();
// }

// public static void main(String[] args) {
// int numbers[] = { 1, 5, 3, 2, 4 };
// countSort(numbers);
// printArr(numbers);
// }
// }

// public class Test {
// public static void main(String[] args) {
// int n = 5;

// Scanner sc = new Scanner(System.in);
// int arr[] = new int[n];
// for (int i = 0; i < arr.length; i++) {
// arr[i] = sc.nextInt();
// System.out.print(arr[i] + " ");
// }
// // for(int i=0; i<arr.length; i++){
// // System.out.print(arr[i]+" ");
// // }
// }
// }

// Searching Element in array

// public class Test {

// public static void main(String[] args) {

// int arr[] = {10, 20, 30, 40, 50};
// int target = 40;

// // boolean found = true;

// int index = -1;

// for(int i=0; i<arr.length; i++){
// if(arr[i]==target){
// // found = true;
// index = i;
// break;
// }else{
// // found = false;
// }
// }
// if(index!=1){
// System.out.println("Element Found");
// System.out.println(index);
// }else{
// System.out.println("Element Not found");
// }

// }
// }

// Leet code product of Array Except Self

// public class Test{
// public static void main(String[] args) {
// int nums[] = {10, 20, 30, 40, 50};
// int n = nums.length;

// for( int i=0; i<n; i++){
// int product = 1;
// for(int j=0; j<n; j++){
// if(i!=j){
// product = product * nums[j];
// }
// }
// nums[i] = product;
// System.out.println(nums[i]);
// }
// }
// }

// // prefix sufix

// class Test{
// public int[] productExceptSelf(int[] nums) {
// int n = nums.length;
// int[] prefix = new int[n];
// int[] sufix = new int[n];

// prefix[0] = nums[0];
// }
// }

// // Rotate an array

// public class Test {

// public static int rotate(int n[]){
// int left = 0, right = n.length-1;

// }

// public static void main(String[] args){
// int num[] = {2,4,5,6,7,0,1};

// System.out.println(rotate(num););
// }
// }