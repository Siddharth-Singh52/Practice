class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = left + 1;

        while(right < n){
            if(nums[left] == 0 && nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right++;
                left++;
            }
            else if(nums[left] == 0 && nums[right] == 0){
                right++;
            }
            else if(nums[left] != 0 && nums[right] != 0){
                right++;
                left++;
            }
            else if(nums[left] != 0 && nums[right] == 0){
                right++;
                left++;
            }
        }
    }
}
