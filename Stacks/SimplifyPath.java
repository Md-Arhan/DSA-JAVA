package Stacks;

import java.util.Stack;

public class SimplifyPath {
    public static String isFilePath(String str) {
        Stack<String> s = new Stack<>();
        String[] path = str.split("/");

        for (String part : path) {
            if (part.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else if (part.equals(".") || part.equals("")) {

            } else {
                s.push(part);
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (String dir : s) {
            sb.append("/").append(dir);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        String str = "/apnacollege/../as/..";
        System.out.println(isFilePath(str));
    }
}



/*
Stack extends Vector in Java.

Vector maintains elements in the order they were added (like an ArrayList).

So when you use for-each, it's like you're looping through an array from index 0 to index n-1.

for-each is designed to traverse the elements in insertion order (start to end).

It does not follow the internal logic of the collection type (such as LIFO for Stack or random order for HashSet).

The for-each loop always runs from start to end.
 */