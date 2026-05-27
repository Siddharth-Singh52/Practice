class Solution {

    public List<String> generateParenthesis(int n) {

        // List to store all valid answers
        List<String> res = new ArrayList<>();

        // Start recursion
        // open = number of '(' used
        // close = number of ')' used
        // temp = current generated string
        fun(0, 0, new StringBuilder(), res, n);

        // Return final list
        return res;
    }

    void fun(int open, int close, StringBuilder temp, List<String> res, int n) {

        // Base Case:
        // If total open and close brackets become n
        // then one valid parenthesis string is formed
        if(open == n && close == n) {

            // Convert StringBuilder into String
            // and store answer
            res.add(temp.toString());

            return;
        }

        // Choice 1:
        // Add '(' only if open brackets are still available
        if(open < n) {
            temp.append("(");

            // Explore further
            fun(open + 1, close, temp, res, n);

            // Backtrack:
            // Remove last added '(' so other possibilities can be explored
            temp.deleteCharAt(temp.length() - 1);
        }

        // Choice 2:
        // Add ')' only if close brackets are less than open brackets otherwise string becomes invalid
        if(close < open) {
            temp.append(")");

            // Explore further
            fun(open, close + 1, temp, res, n);

            // Backtrack: Remove last added ')'
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
