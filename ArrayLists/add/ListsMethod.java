package add;
// package ArrayLists;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class ListsMethod {
//     public static void main(String[] args) {
//         List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

//         System.out.println("Original list: " + names);

//         // Modifying an element (allowed)
//         names.set(1, "David");
//         System.out.println("Modified list: " + names);

//         // Adding an element (not allowed)
//         try {
//         names.add("Eve");
//         } catch (UnsupportedOperationException e) {
//         System.out.println("Error: Cannot add elements to this list.");
//         }

//         // Output :
//         // Original list: [Charlie, Alice, Bob]
//         // Modified list: [Charlie, David, Bob]
//         // Error: Cannot add elements to this list.



//         // Create an ArrayList from the fixed-size list

//         List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob"));

//         // Now you can add or remove elements
//         names.add("Eve");
//         System.out.println("Resizable ArrayList: " + names);

//         // Output : Resizable ArrayList: [Charlie, Alice, Bob, Eve]

//     }
// }
