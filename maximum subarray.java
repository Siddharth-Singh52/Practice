class Solution {
    public int maxSubArray(int[] nums) {

        int bestEnding = nums[0];  
        int ans = nums[0];

        for(int i = 1; i < nums.length; i++){
            int a = bestEnding + nums[i]; // element is added as we want contiguous array
            int b = nums[i];
            bestEnding = Math.max(a, b); // current subarray ka max
            ans = Math.max(ans, bestEnding); // overall maximum of subarray sum
        }
        return ans;
    }
}
