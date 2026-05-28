class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Final answer list
        // Stores all valid combinations
        List<List<Integer>> res = new ArrayList<>();

        // Temporary list
        // Stores current combination being formed
        List<Integer> diary = new ArrayList<>();

        // Total number of elements
        int n = candidates.length;

        // Start recursion from:
        // idx = 0
        // sum = 0
        fun(candidates, target, res, diary, n, 0, 0);
        return res;
    }

    void fun(int[] candidates, int target, List<List<Integer>> res, List<Integer> diary, int n, int idx, int sum){

        // Base Case: If all elements are processed
        if(idx == n){
            // If current sum becomes target then current combination is valid
            if(sum == target){
                // Store COPY of current combination because diary changes later during backtracking
                res.add(new ArrayList<>(diary));
            }
            // Stop recursion
            return;
        }

        // Choice 1: TAKE current element
        // Take element only if sum does not exceed target
        if(candidates[idx] + sum <= target){
            
            diary.add(candidates[idx]); // Choose current element

            sum += candidates[idx]; // Add current element into sum

            // Recursive call with SAME index
            // because same element can be reused
            fun(candidates, target, res, diary, n, idx, sum);

            // BACKTRACKING STEP: Remove last added element to restore previous state
            diary.remove(diary.size() - 1);

            // Restore previous sum
            sum -= candidates[idx];
        }

        // Choice 2: SKIP current element
        // Move to next index
        // Current element is ignored
        fun(candidates, target, res, diary, n, idx + 1, sum);

        // End current recursion call
        return;
    }
}
