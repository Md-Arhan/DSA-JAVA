package Arrays;

public class BuySellsStock {
    public static int buySellStocks(int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxValue = 0;

        for (int i = 0; i < prices.length; i++) {
            int sellingPrice = prices[i];
            if (buyPrice < sellingPrice) {
                int profit = sellingPrice - buyPrice;
                // System.out.println(profit);
                maxValue = Math.max(maxValue, profit);
            } else {
                buyPrice = sellingPrice;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };

        System.out.println(buySellStocks(prices));
    }
}
