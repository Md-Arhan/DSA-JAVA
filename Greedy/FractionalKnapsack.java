import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;

        //
        // int[] values = { 60, 100, 120 };
        // int[] weights = { 10, 5, 30 };
        // int W = 30;
        //Output = 220;
        
        // sorting
        double ratio[][] = new double[value.length][2];
        // 0th col idx, 1st col -> ratio

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = value[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // Arrays.sort(ratio, (a, b) -> Double.compare(a[1], b[1]));

        int capacity = w;
        int finalVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += value[idx];
                capacity -= weight[idx];
            } else {
                // include fractional value
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Final Value = " + finalVal);

    }
}


/*
 * Why value[i] / weight[i]?
This gives the value per unit weight of each item — also called the value-to-weight ratio.
 */