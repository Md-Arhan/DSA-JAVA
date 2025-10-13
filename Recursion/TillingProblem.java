package Recursion;

public class TillingProblem {
    public static int tillinProblem(int n) {
        //Base case
        if (n==0 || n==1) {
         return 1;
        }
 
        //Work
        //vertical choice
        int verticalTiles = tillinProblem(n-1);
        //Horizontal choice
        int horizontalChoice = tillinProblem(n-2);
 
        int totalWays = verticalTiles + horizontalChoice;
 
        return totalWays;
     }
 
     public static void main(String[] args) {
         System.out.println(tillinProblem(4));
     }
}
