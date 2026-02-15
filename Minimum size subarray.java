class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        int sum = 0;
        int n = nums.length;

        for(high = 0; high < n; high++){
            sum = sum + nums[high];

            while(sum >= target){
                int length = high - low + 1;
                min = Math.min(length, min);
                sum = sum - nums[low];
                low++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
