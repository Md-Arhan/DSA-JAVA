import java.util.ArrayList;
import java.util.Collections;

public class JobSequency {
    
    static class Job{
        int deadLine;
        int profit;
        int id;
        Job(int i, int d, int p){
            id = i;
            deadLine = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = {
            {4, 2},
            {1, 10}, 
            {1, 40}, 
            {1, 30}
        };

        ArrayList<Job> jobs = new ArrayList<>();             //Job jobs[] = new Job[jobInfo.length];

        for(int i=0; i<jobInfo.length; i++){
           jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);  //Descending Order

        ArrayList<Integer> seq = new ArrayList<>();

        int time = 0;

        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadLine > time){ 
                seq.add(curr.id);
                time++;
            }
        }

        //print seq
        System.out.println("Max jobs = " + seq.size());
        for(int i = 0; i<seq.size(); i++){
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}



/*
 * hy this works without this:
In this case, the constructor parameters are named i, d, and p, which do not conflict with the class variables id, deadLine, and profit.

So:

id = i; 
 */


 /*
  * When you must use this:
If the parameter names are the same as the instance variable names:

Job(int id, int deadLine, int profit) {
    this.id = id;              // disambiguates: this.id (class var) = id (parameter)
    this.deadLine = deadLine;
    this.profit = profit;
}
Without this, you'd just be assigning the parameter to itself (id = id;) — which does nothing to the class variable!
  */