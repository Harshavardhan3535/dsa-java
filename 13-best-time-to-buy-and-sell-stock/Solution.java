class Solution {

    // One pass: remember the lowest price so far - O(n) time, O(1) space
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);   // sell today
            minPrice = Math.min(minPrice, prices[i]);                // cheapest buy so far
        }
        return maxProfit;
    }
}
