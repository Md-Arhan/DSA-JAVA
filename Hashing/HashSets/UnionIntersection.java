package Hashing.HashSets;

import java.util.HashSet;

public class UnionIntersection {
    static HashSet<Integer> set = new HashSet<>();

    public static int union(int arr1[], int arr2[]){

        set.clear();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        return set.size();
    }

    public static int ineterSection(int arr1[], int arr2[]){
        
        set.clear();

        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);   //why we are deleting bcz if we dont delete futher if we got more same number it increases, only once it should increase
                System.out.print(arr2[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9 ,4};

        int union = union(arr1, arr2);
        int interSection = ineterSection(arr1, arr2);
        System.out.println(union);
        System.out.println(interSection);
    }
}
