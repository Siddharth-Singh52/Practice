class Solution {
    public int maxNumberOfBalloons(String text) {
        char[] arr1 = text.toCharArray();

        // HashMap to store frequency of characters present in input text
        HashMap<Character, Integer> have = new HashMap<>();

        // STEP 1: Count frequency of given text
        for(int i = 0; i < arr1.length; i++){
            // If character already exists → increment count
            // Else → initialize with 1
            have.put(arr1[i], have.getOrDefault(arr1[i], 0) + 1);
        }
        
        String balloon = "balloon"; // String we want to check
        char[] arr2 = balloon.toCharArray(); // Convert to char array

        // HashMap to store required frequency of each character
        HashMap<Character, Integer> need = new HashMap<>();

        // STEP 2: Count frequency of "balloon"
        for(int i = 0; i < arr2.length; i++){
            // Store how many times each character is needed
            // Example: l → 2, o → 2, others → 1
            need.put(arr2[i], need.getOrDefault(arr2[i], 0) + 1);
        }

        // Initialize result with maximum value
        // We will minimize this later
        int res = Integer.MAX_VALUE;

        // STEP 3: Compare "have" vs "need"
        for(Map.Entry<Character, Integer> entry : need.entrySet()){
            
            // Character required
            char c = entry.getKey();
            // Frequency needed for that character
            int fneed = entry.getValue();

            // Frequency available in input text
            // If character not present → default 0
            int fhave = have.getOrDefault(c, 0);

            // Calculate how many times this character can contribute
            // Example: if need = 2 and have = 4 → we can use it 2 times
            int times = fhave / fneed;

            // Take minimum across all characters
            // Because final answer depends on the limiting character
            res = Math.min(res, times);
        }

        // Return maximum number of times "balloon" can be formed
        return res;
    }
}
