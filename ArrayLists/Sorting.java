import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        //Ascending Order
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //Descending Order
        //optimize approach 
        Collections.sort(list, Collections.reverseOrder());
        //Comparator - fxn logic
        System.out.println(list);
    }
}
