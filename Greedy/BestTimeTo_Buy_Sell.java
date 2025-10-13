package Greedy;

public class BestTimeTo_Buy_Sell {
    public static int maxProfit(int prices[]){
        int buy = prices[0];
        int max_profit = 0;

        for(int i=1; i<prices.length; i++){
            if (prices[i] < buy) {
                buy = prices[i];  // Update the minimum price so far
            }else if(prices[i] - buy >  max_profit){
                max_profit = prices[i] - buy;
            }
        }
        return max_profit;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        int max_profit = maxProfit(prices);
        System.out.println(max_profit);
    }
}
