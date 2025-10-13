# Commonly Used Comparator Methods

     Method	                            Description
compare(T o1, T o2)	         Main abstract method. Compares two objects.
reversed()	                 Returns a comparator that reverses the order.
thenComparing(...)	         Chains a second comparator if the first one returns 0 (equal).

thenComparingInt(...), 
thenComparingDouble(...), 
thenComparingLong(...)	    Like thenComparing, but for primitives.

comparing(...)	            Static method to create a comparator from a key extractor function.
comparingInt(...),
comparingDouble(...),
comparingLong(...)	        Optimized comparators for primitive return types.

naturalOrder()	            Returns a comparator that uses Comparable.compareTo.
reverseOrder()	            Returns a comparator that reverses natural ordering.
nullsFirst(...)
 / nullsLast(...)	        Handles null values in sorting.

equals(Object obj)	        Checks equality between two comparators.
minBy(...), maxBy(...)	    Returns the lesser/greater of two elements using a comparator.


# Comparator

A Comparator is an object that implements the compare(T o1, T o2) method, which compares two objects of the same type and returns:​

A negative integer if o1 is less than o2.
Zero if o1 and o2 are equal.
A positive integer if o1 is greater than o2.

he Comparator<T> in Java is an interface, but it can be used to create objects that define custom sorting logic.​

The Comparator<T> interface defines a method compare(T o1, T o2) for comparing two objects of type T. While interfaces themselves cannot be instantiated, you can create objects that implement this interface, thereby defining custom comparison logic.


# Comparable Interface

Comparable<T> Interface
The Comparable<T> interface is a part of the java.lang package and is used to define the natural ordering of objects of a class. By implementing this interface, a class indicates that its instances can be compared to each other, allowing them to be sorted automatically by various Java utilities, such as Collections.sort() and Arrays.sort().

compareTo(T o) Method
The compareTo(T o) method is the sole method defined in the Comparable<T> interface. It compares the current object (this) with the specified object (o) for order. The method returns:​
Runestone Academy

A negative integer if this is less than o.

Zero if this is equal to o.

A positive integer if this is greater than o.​

This return value allows objects to be sorted in a natural order, which is essential for operations like sorting and searching.



W**hile the compareTo(T o) method defines the natural ordering of objects within a class, the compare() method from the Comparator<T> interface allows for external, customizable sorting logic. In some cases, such as when using utility methods like Comparator.comparing(), the compare() method is invoked internally to perform comparisons, providing flexibility and separation of concerns in sorting operations.