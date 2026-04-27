class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();

        // STEP 1: Count frequency of characters
        for(int i = 0; i < arr.length; i++){
            // If character already exists → increment count
            // Otherwise → initialize with 1
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Flag to check if any character has odd frequency
        boolean odd = false;

        // Variable to store result (length of longest palindrome)
        int res = 0;

        // STEP 2: Process each character frequency
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            // Get frequency of current character
            int value = entry.getValue();

            // Case 1: If frequency is even
            if(value % 2 == 0){
                // We can use all characters in palindrome
                res += value;
            }
            else{
                // Case 2: If frequency is odd
                // Use the largest even part (value - 1)
                res += value - 1;
                odd = true; // Mark that at least one odd exists
            }
        }

        // STEP 3: Add one center character (if any odd exists)
        if(odd == true){
            // Only one odd character can be placed in the center
            res += 1;
        }
        // Return the maximum palindrome length
        return res;
    }
}
