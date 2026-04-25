class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {

        // HashMap to store frequency of characters from magazine
        HashMap<Character, Integer> map = new HashMap<>();

        // Convert strings to char arrays for easy traversal
        char[] arr1 = ransomNote.toCharArray();
        char[] arr2 = magazine.toCharArray();

        // STEP 1: Count frequency of magazine characters
        for(int i = 0; i < arr2.length; i++){

            // If character already exists → increase count
            // Else → initialize with 1
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }

        // STEP 2: Check if ransomNote can be formed
        for(int i = 0; i < arr1.length; i++){

            // Check:
            // 1. Character exists in map
            // 2. Frequency is still available (> 0)
            if(map.containsKey(arr1[i]) && map.get(arr1[i]) > 0){

                // Use one occurrence of that character
                map.put(arr1[i], map.get(arr1[i]) - 1);
            }
            else{
                // Character not available OR insufficient count
                return false;
            }
        }

        // If all characters are successfully matched
        return true;
    }
}
