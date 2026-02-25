class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double maxAverage = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        maxAverage = (double)sum/k;

        for(int i = k; i < nums.length; i++){
            sum -= nums[i-k];
            sum += nums[i];
            maxAverage = Math.max(maxAverage, (double)sum/k);
        }

        return maxAverage;
    }
}
