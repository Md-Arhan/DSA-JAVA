package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//TC = O(n)

// if we are sorting then our time complexity will be O(nlogn)

public class ActivitySelection {
    
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //Sorting process
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1]= start[i];
            activities[i][2]= end[i];
        }

        //Lambda function calling to sort an array  
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();


        maxAct = 1;                                  //This is uses when we get array non-sorted
        ans.add(0);                                  //ans.add(activities[0][0])

        int lastEnd = end[0];                        //activities[0][2];
        for(int i=1; i<end.length; i++){
            if (start[i] >= lastEnd) {               //start[0][1] >= lastEnd
                //activity select
                maxAct++;
                ans.add(i);                          //ans.add(activities[i][0])
                lastEnd = end[i];                    //activities[i][2];
            }
        }

        System.out.println("Maximum activity = " + maxAct);

        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}



/*
 * int[][] activities = new int[start.length][2];

for (int i = 0; i < start.length; i++) {
    activities[i][0] = start[i];
    activities[i][1] = end[i];
}

Arrays.sort(activities, Comparator.comparingInt(o -> o[1]));

for (int[] act : activities) {
    System.out.println("Start: " + act[0] + ", End: " + act[1]);
}

output :
Start: 1, End: 2   ← original index 1
Start: 3, End: 4   ← original index 2
Start: 0, End: 6   ← original index 3
Start: 5, End: 7   ← original index 0

so the only difference handling the index to identify on which index we are
Sorting doesn't change the data — it just changes the order.

If you care about which original element you're working with after sorting, you need to store the index before sorting.


      Without storing index	                   With storing index
  
You lose track of where it came from	You can trace it back to the original position
Good for simple sorting and printing	Crucial for logic based on original data (like selecting activities, reporting results, etc.)
Can't say "activity 2 was selected"	    You can say "activity 2 was selected"
 */