class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> h = new HashMap<>();
        for(int low = 0; low < nums.length; low++){
            int diff = target - nums[low];
            if(h.containsKey(diff)){
                return new int[] {h.get(diff), low};
            }
            h.put(nums[low], low);
        }
        return new int[]{-1, -1};
    }
}
