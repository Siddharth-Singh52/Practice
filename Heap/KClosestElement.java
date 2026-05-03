class Solution {

    // Pair class to store element and its distance from x
    class Pair{
        int element;
        int difference;

        Pair(int element, int difference){
            this.element = element;
            this.difference = difference;
        }
    }

    // Function to calculate absolute difference between element and x
    public int diff(int element, int x){
        int res = Math.abs(x - element); // distance from target
        return res;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;

        // Max Heap based on:
        // 1. Larger difference should come first (so it can be removed)
        // 2. If difference same, larger element removed first (to keep smaller ones)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if(a.difference != b.difference){
                return b.difference - a.difference; // max heap on difference
            }
            else{
                return b.element - a.element; // tie-breaker
            }
        });
        
        // Step 1: Add first k elements into heap
        // (initial candidates for closest elements)
        for(int i = 0; i < k; i++){
            pq.add(new Pair(arr[i], diff(arr[i], x)));
        }

        // Step 2: Process remaining elements
        // For each new element:
        // - Add it into heap
        // - Remove the element with largest difference
        // => heap always stores k closest elements
        for(int i = k; i < n; i++){
            pq.add(new Pair(arr[i], diff(arr[i], x)));
            pq.poll(); // remove farthest element
        }

        // Step 3: Extract elements from heap
        // (these are k closest elements but not sorted)
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().element);
        }

        // Step 4: Sort result because problem expects sorted output
        Collections.sort(res);

        return res;
    }
}
