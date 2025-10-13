package Assignment;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumber {
    public static ArrayList<Integer> lonelyNumber(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        //Check middle elements for lonliness
        for(int i=1; i<nums.size()-1; i++){
            if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i+1)){
                list.add(nums.get(i));
            }
        }

        //Middle edge cases for the first and last elements
        if(nums.size() == 1){
            list.add(nums.get(0));
        }else if(nums.size() > 1){
            if(nums.get(0) + 1 < nums.get(1)){
                list.add(nums.get(0));
            }
            if(nums.get(nums.size()-2) + 1 < nums.get(nums.size()-1)){
                list.add(nums.get(nums.size()-1));
            }
        }

        return list;
    }

    public static ArrayList<Integer> lonelyNumber2(ArrayList<Integer> list){

        //Check middle elements for lonliness
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            boolean isLonely = true;

            // Check for neighbors
            for (int j = 0; j < list.size(); j++) {
                if (i != j) { // Avoid comparing the number with itself
                    if (list.get(j) == current - 1 || list.get(j) == current + 1) {
                        isLonely = false;
                        break;
                    }
                }
            }

            if (isLonely) {
                nums.add(current);
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);

        ArrayList<Integer> res = lonelyNumber(nums);
        System.out.println(res);

    }
}
