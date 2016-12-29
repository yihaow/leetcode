public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int current = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] >= current) {
                profit += prices[i] - current;
            }
            current = prices[i];
        }
        return profit;
    }
}
