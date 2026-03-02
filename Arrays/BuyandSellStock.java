class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;
            max = Math.max(max, profit);

        }
        return max;
    }
}
