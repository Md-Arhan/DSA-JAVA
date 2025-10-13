# what are generics

Generics in Java are a way to create classes, interfaces, and methods that operate on typed parameters, so you can write type-safe, reusable, and flexible code without sacrificing type information.

Example : 

class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

Box<Integer> intBox = new Box<>();
intBox.set(123);
System.out.println(intBox.get()); // 123

Box<String> strBox = new Box<>();
strBox.set("hello");
System.out.println(strBox.get()); // hello


* Generics Methods

public <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.println(element);
    }
}

* Benefits of Generics:

✅ Type safety – catch errors at compile time.
✅ Code reuse – write once, use for many types.
✅ No casting needed – cleaner syntax.


# getClass():

⚠️ Type Erasure:
At runtime, Java erases generic type information due to type erasure. For example:

List<String> list1 = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();
System.out.println(list1.getClass() == list2.getClass()); // true

(Generics only exist at compile time, not runtime).

# What is getClass() in Java?

getClass() is a method from the Object class in Java. Since every class in Java implicitly extends Object, all objects have access to getClass().

object.getClass();

It returns a Class object that represents the runtime class of the object.

Example 1: 

String str = "Hello";
System.out.println(str.getClass());

* Output :
String str = "Hello";
System.out.println(str.getClass());


Example 2:

class Animal {}
class Dog extends Animal {}

Animal a = new Dog();
System.out.println(a instanceof Dog); // true
System.out.println(a.getClass() == Dog.class); // true
System.out.println(a.getClass() == Animal.class); // false

* Line-by-Line Breakdown:

1️⃣ System.out.println(a.getClass() == Dog.class);
a.getClass() returns the runtime class → Dog.class

Dog.class is a reference to the Class object representing Dog

✅ This is true because a points to a Dog object

2️⃣ System.out.println(a.getClass() == Animal.class);
a.getClass() is still Dog.class (runtime type)

Animal.class is the Class object for the Animal class

❌ This is false because Dog.class != Animal.class

| Expression                     | Value   | Why                             |
| ------------------------------ | ------- | ------------------------------- |
| `a instanceof Animal`          | `true`  | `Dog` is a subclass of `Animal` |
| `a instanceof Dog`             | `true`  | `a` actually **is** a `Dog`     |
| `a.getClass() == Dog.class`    | `true`  | Runtime type is `Dog`           |
| `a.getClass() == Animal.class` | `false` | Runtime type ≠ `Animal`         |



# @SuperWarnings("unchecked")
@SuppressWarnings("unchecked") is an annotation in Java that tells the compiler to ignore unchecked type warnings — particularly useful when working with generics and legacy code.

 What Are "Unchecked Warnings"?
They occur when the compiler cannot guarantee type safety at compile time.

Usually this happens when:
You're using raw types (non-generic versions).
You're doing unchecked casts between generic types.

Yes, you're exactly right — when you're working with non-generic (raw) types but need to use them in a generic context, Java will often give you a compiler warning like:
"Unchecked conversion from raw type to generic type."
To suppress this warning (when you're sure it's safe), you use:

Example :
List list = new ArrayList();  // raw type — not type-safe
list.add("Hello");

List<String> strList = list; // ⚠️ unchecked warning: unchecked conversion


# LinkedList for-loop

only works on objects stored inside the LinkedList because:

Java’s LinkedList is a generic collection of objects (LinkedList<Node> means it stores Node objects).

The method ll.get(i) returns the object at index i — here, a Node.

You can’t have a LinkedList of primitives like int directly (Java’s generics work only with objects).

For primitives, you use wrapper classes (Integer, Double, etc.), which are objects.

* How does this work with a LinkedList?
ll is a Java LinkedList, which internally is a doubly linked list.
ll.size() returns the number of elements.
ll.get(i) returns the element at index i.

* Important details:
Unlike arrays, ll.get(i) on a LinkedList is not O(1). It internally traverses the list starting from head or tail, following .next pointers until it reaches index i.

So, doing ll.get(i) repeatedly inside a loop results in O(n²) time complexity — very inefficient for large lists.

Example : 
LinkedList<Integer> ll = new LinkedList<>();
ll.add(10);
ll.add(20);
ll.add(30);

for (int i = 0; i < ll.size(); i++) {
    Integer val = ll.get(i);
    System.out.println(val);
}

* Output :
10
20
30


# Collisions

When using hashing, the goal is typically to achieve constant time complexity — O(1) — for operations like insertion, deletion, and search, assuming a good hash function and low load factor.

However, in the worst case, hashing can degrade to linear time complexity, O(n). This happens mainly due to collisions.

🔁 Why the Worst-Case Happens: Collisions
When multiple keys hash to the same index, a collision occurs. Depending on how the collisions are handled (via chaining or open addressing), performance can suffer.

1. Chaining (using linked lists or other structures at each index)
Worst case: All n keys hash to the same index.

Then, one index has a linked list (or another structure) with n elements.

Searching becomes O(n) in that list.

2. Open Addressing (like linear probing, quadratic probing, double hashing)
All elements are stored in the array itself.

When collisions occur, probing continues to find an empty slot.

In the worst case (high load factor or poor hash function), probing may take O(n) time.

| Operation | Best Case | Average Case | Worst Case |
| --------- | --------- | ------------ | ---------- |
| Search    | `O(1)`    | `O(1)`       | `O(n)`     |
| Insert    | `O(1)`    | `O(1)`       | `O(n)`     |
| Delete    | `O(1)`    | `O(1)`       | `O(n)`     |
