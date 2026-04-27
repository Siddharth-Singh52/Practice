class Solution {

    // Pair class to store character and its frequency
    class Pair{
        Character element;
        int frequency;

        Pair(Character element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
    }

    public String reorganizeString(String s) {
        int n = s.length();

        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Step 2: Create Max Heap (PriorityQueue)
        // Higher frequency characters will come first
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.frequency != b.frequency){
                return b.frequency - a.frequency; // max heap based on frequency
            }
            else{
                // If frequency same → lexicographically larger first (optional)
                return b.element.compareTo(a.element);
            }
        });

        // Add all characters with their frequency into heap
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Result string builder
        StringBuilder res = new StringBuilder();
        int i = 0; // pointer to track current position

        // Step 3: Build result string
        while(!pq.isEmpty()){

            // Take most frequent character
            Pair p = pq.poll();
            Character elem = p.element;
            int freq = p.frequency;

            // If first position OR last added character is different
            if(i == 0 || res.charAt(i - 1) != elem){

                // Safe to add this character
                res.append(elem);
                i++;

                // Decrease its frequency
                freq--;

                // If still remaining, push back into heap
                if(freq > 0){
                    pq.add(new Pair(elem, freq));
                }
            }
            else{
                // If same character would repeat → need alternative

                // If no other character available → not possible
                if(pq.isEmpty()){
                    return "";
                }

                // Take second most frequent character
                Pair p1 = pq.poll();
                Character elem2 = p1.element;
                int freq2 = p1.frequency;

                // Add second character
                res.append(elem2);
                i++;

                // Decrease its frequency
                freq2--;

                // If still remaining, push back
                if(freq2 > 0){
                    pq.add(new Pair(elem2, freq2));
                }

                // Put first character back for future use
                pq.add(new Pair(elem, freq));
            }
        }

        // Final result
        return res.toString();
    }
}
