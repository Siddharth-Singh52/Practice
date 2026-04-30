class Solution {

    // Pair class to store word and its frequency
    class Pair{
        String element;
        int frequency;

        Pair(String element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        // Step 1: Count frequency of each word
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // Step 2: Create Min Heap
        // Priority:
        // 1. Smaller frequency first
        // 2. If same freq → lexicographically larger word first (so it gets removed)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.frequency != b.frequency){
                return a.frequency - b.frequency; // min heap on frequency
            }
            else{
                return b.element.compareTo(a.element); // reverse lexicographical
            }
        });

        // Step 3: Traverse map entries
        for(Map.Entry<String, Integer> entry : map.entrySet()){

            String s = entry.getKey();
            int freq = entry.getValue();

            // If heap size is less than k → directly add
            if(pq.size() < k){
                pq.add(new Pair(s, freq));
                continue; // skip rest, go next
            }

            // If heap already has k elements:
            // Add new element first
            pq.add(new Pair(s, freq));

            // Then remove the least important element (top of min heap)
            // This ensures heap always contains top k frequent words
            pq.poll();
        }

        // Step 4: Extract elements from heap
        List<String> res = new ArrayList<>();

        while(!pq.isEmpty()){
            res.add(pq.poll().element); // remove from heap (smallest first)
        }

        // Step 5: Reverse because we need highest frequency first
        Collections.reverse(res);

        return res;
    }
}
