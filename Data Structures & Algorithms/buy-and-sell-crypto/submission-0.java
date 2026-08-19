class Solution {
    public int maxProfit(int[] prices) {
        int mx = 0;
        int minStock = prices[0];
        for (int i = 0; i < prices.length; i++) {
            mx = Math.max(mx, prices[i] - minStock);
            minStock = Math.min(minStock, prices[i]);
        }
        return mx;
    }
}
