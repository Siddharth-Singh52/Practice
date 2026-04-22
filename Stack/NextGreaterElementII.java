public int[] nextGreaterElements(int[] nums) {

    int n = nums.length;

    // Stack will store elements (not indices)
    // It will help us maintain a decreasing stack (monotonic stack)
    Stack<Integer> stack = new Stack<>();

    // Result array to store next greater elements
    int[] res = new int[n];

    // STEP 1: Handle circular nature
    // We push elements from (n-2 → 0) into stack
    // Why?
    // Because last element (n-1) ke liye hume circular traversal simulate karna hai
    // So we preload stack with previous elements
    for(int i = n - 2; i >= 0; i--){
        stack.push(nums[i]);
    }

    // STEP 2: Traverse from right to left
    for(int i = n - 1; i >= 0; i--){

        // Remove all elements from stack that are <= current element
        // Because they can NEVER be the next greater element
        // (since current element unse bada ya equal hai)
        while(!stack.isEmpty() && stack.peek() <= nums[i]){
            stack.pop();
        }

        // If stack becomes empty → no greater element exists
        if(stack.isEmpty()){
            res[i] = -1;
        }
        else{
            // Top of stack is the next greater element
            res[i] = stack.peek();
        }

        // Push current element into stack
        // So it can act as a candidate for elements on left side
        stack.push(nums[i]);
    }

    // Return final result
    return res;
}
