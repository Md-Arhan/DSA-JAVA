# Abstract Class

Can have abstract methods (no body) and non-abstract methods (with body).

Can have constructors.

Can have instance variables (state).

Supports single inheritance (a class can only extend one abstract class).

Used when classes are closely related and you want to share common code.

 # Interface

Is a pure abstraction (contract) → until Java 7: only abstract methods.

From Java 8 → can also have default and static methods.

From Java 9 → can also have private methods.

Cannot have constructors.

All variables are public static final (constants only).

Supports multiple inheritance (a class can implement multiple interfaces).

Used when you want to define a contract/behavior that can be implemented by unrelated classes.