class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;

        // Result array: store number of days to wait
        int[] res = new int[n];

        // Last element ke liye koi future day nahi hota → 0
        res[n-1] = 0;

        // Stack stores indices (not values)
        Stack<Integer> stack = new Stack<>();

        // Push last index as starting point
        stack.push(n-1);

        // Traverse from right to left
        for(int i = n-2; i >= 0; i--){

            // Remove all indices whose temperature is <= current
            // because they cannot be the "next warmer day"
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                stack.pop();
            }

            // If stack empty → no warmer day exists
            if(stack.isEmpty()){
                res[i] = 0;
            }
            else{
                // Next warmer day index - current index
                res[i] = stack.peek() - i;
            }

            // Push current index for future comparisons
            stack.push(i);
        }

        return res;
    }
}
