class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 1;
        int n = nums.length;
        int j = 1;
        while(j < n){
            if(nums[j] == nums[i]){
                j++;
            }
            else {
                nums[i+1] = nums[j];
                i++;
                k++;
                j++;
            }
        }
        return k;
    }
}
