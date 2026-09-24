class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;

        while (right <= prices.length - 1) {
            if (prices[right] < prices[left]) {
                left = right;
            } else {
                int profit = prices[right] - prices[left];
                if (maxProfit < profit) {
                    maxProfit = profit;
                }
            }
            right++;
        }
        return maxProfit;
    }
}
