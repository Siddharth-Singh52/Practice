class Solution {

    // Pair class to store element and its frequency
    class Pair{
        int element;
        int frequency;

        Pair(int element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // HashMap to store frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // STEP 1: Count frequency of elements
        for(int i = 0; i < n; i++){

            // If element already exists → increment count
            // Else → initialize with 1
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // STEP 2: Create Min Heap (based on frequency)
        // Heap will store Pair(element, frequency)
        // Smallest frequency will be at the top
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {

            // Compare based on frequency
            if(a.frequency != b.frequency){
                return a.frequency - b.frequency; // min heap
            }
            else{
                // Optional: tie-break using element value
                return a.element - b.element;
            }
        });

        // STEP 3: Process all entries in map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int value = entry.getKey();     // element
            int freq = entry.getValue();    // frequency

            // If heap size is less than k → add directly
            if(pq.size() < k){
                pq.add(new Pair(value, freq));
            }

            // If current frequency is greater than smallest in heap
            else if(freq > pq.peek().frequency){

                // Remove smallest frequency element
                pq.poll();

                // Add current element
                pq.add(new Pair(value, freq));
            }
        }

        // STEP 4: Extract elements from heap
        int[] res = new int[k];
        int i = 0;

        // Heap contains k most frequent elements
        while(!pq.isEmpty()){
            // Remove element from heap and store in result
            res[i++] = pq.poll().element;
        }

        return res;
    }
}
