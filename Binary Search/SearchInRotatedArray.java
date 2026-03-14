class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length - 1;

        int low = 0;
        int high = n;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }

            // Part 1 : Left side sorted
            if(nums[mid] >= nums[low]){

                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            // Part 2 : Right side sorted
            else{

                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
