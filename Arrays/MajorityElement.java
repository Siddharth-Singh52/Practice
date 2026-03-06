class Solution {
    public int majorityElement(int[] nums) {

        int element = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){

            if(count == 0){
                element = nums[i];
                count++;
            }
            else if(nums[i] == element){
                count++;
            }
            else{
                count--;
            }
        }

        count = 0;
        int max = nums.length/2;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element){
                count++;
            }
            if(count > max){
                return element;
            }
        } 
        return -1;
    }
}
