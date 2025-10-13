import java.util.ArrayList;

public class Basics {

    public static void main(String[] args) {
        // String | Boolean | Float
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        // Add Operation

        list.add(1); // O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(1, 9);
        // System.out.println(list.size()); //Size
        // System.out.println(list);

        // //Get Operation

        // int ele = list.get(2); //O(1)
        // System.out.println(ele);

        // //Removed Operation

        // list.remove(3); //O(n)  bcz of re sizing
        // System.out.println(list);

        // //Set Element at Index

        // list.set(2, 10); //O(n)
        // System.out.println(list);

        // //Contain Operation

        // System.out.println(list.contains(10)); //O(n)
        // System.out.println(list.contains(52));

        // //Adding element index without removing the present object, and the present
        // obj move forward
        // list.add(2, 9); //O(1)
        // System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }
}
