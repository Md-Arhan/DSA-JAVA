package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Node;

//Group Anagram Togther




//Longest Word in Dictionary

// public class Assignment {

//     static class Node{
//         Node children[] = new Node[26];
//         Boolean eow = false;

//         Node(){
//             for(int i=0; i<26; i++){
//                 children[i] = null;
//             }
//         }
//     }

//     public static Node root = new Node();

//     public static void insert(String word){
//         Node curr = root;
//         for(int i=0; i<word.length(); i++){
//             int idx = word.charAt(i) - 'a';
//             if (curr.children[idx] == null) {
//                 curr.children[idx] = new Node();
//             }
//             curr = curr.children[idx];
//         }

//         curr.eow = true;
//     }

//     public static String ans = "";

//     public static void longestWord(Node root, StringBuilder temp){
//         if (root == null) {
//             return;
//         }

//         for(int i=0; i<26; i++){
//             if (root.children[i] != null && root.children[i].eow == true) {
//                 /*temp.append(root.children[i].toString()); 
//                  * The reason you cannot append a Node object to a StringBuilder in Java is that StringBuilder is designed to work with string data or string-compatible types (e.g., char, String, int, etc.). Here's a detailed explanation:
//                  * The Node object is not automatically converted into meaningful data. Instead, the toString() method of the Node class is called.
//                  * By default, the toString() method for any Java object (if not overridden) will return the string representation of the memory address of the object, such as:
//                 */
//                 temp.append((char)(i + 'a'));
//                 if (temp.length() > ans.length()) {
//                     ans = temp.toString();
//                 }
//                 longestWord(root.children[i], temp);
//                 temp.deleteCharAt(temp.length()-1);
//             }
//         }
//     }


//     public static void main(String[] args) {
//         String  words[] =  {"w","wo","wor","worl", "world"};

//         for(int i=0; i<words.length; i++){ //O(N*L)
//             insert(words[i]);
//         }

//         longestWord(root, new StringBuilder(""));
//         System.out.println(ans);  //O(N*L)

//     }
// }