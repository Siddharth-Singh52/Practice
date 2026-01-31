class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int left = 0;
        int right = n-1;
        int id = n-1;

        while(left <= right){
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];

            if(a < b){
                arr[id] = b;
                id--;
                right--;
            }
            else {
                arr[id] = a;
                id--;
                left++;
            }
        }
        return arr;
    }
}
