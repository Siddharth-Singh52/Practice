class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int left = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[left]){
                return true;
            }
            else{
                left++;
            }
        }
        return false;
    }
}
