class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n-2; i++){

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int right = n-1;
            int left = i+1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    while(left < n && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(right >= 0 && nums[right] == nums[right+1]){
                        right--;
                    }
                }

                else if(sum > 0){
                    right--;
                }

                else{
                    left++;
                }
            }

        }
        return result;
    }
}
