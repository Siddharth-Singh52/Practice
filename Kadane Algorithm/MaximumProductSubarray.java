class Solution {
    public int maxProduct(int[] nums) {
        
        int bestmax = nums[0];
        int bestmin = nums[0];
        int element = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int a = bestmax * nums[i];
            int b = bestmin * nums[i];
            int c = nums[i];

            bestmax = Math.max(a, Math.max(b, c));
            bestmin = Math.min(a, Math.min(b, c));

            element = Math.max(bestmax, bestmin);

            res = Math.max(res, element);
        }

        return res;
    }
}
