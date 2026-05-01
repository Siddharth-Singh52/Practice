class Solution {
    public int lastStoneWeight(int[] stones) {

        int n = stones.length;

        // Max Heap to always get the heaviest stones first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Edge case: if only one stone, return it directly
        if(n == 1){
            return stones[0];
        }

        // Step 1: Add all stones into max heap
        for (int i = 0; i < n; i++) {
            pq.add(stones[i]);
        }

        // Step 2: Keep smashing until at most one stone remains
        while (pq.size() > 1) {

            // Take two heaviest stones
            int a = pq.poll();
            int b = pq.poll();

            // If they are not equal, push the remaining weight
            // (difference of two stones)
            if (a != b) {
                a = a - b;
                pq.add(a);
            }
            // If equal → both destroyed, nothing added
        }

        // Step 3: If no stones left, return 0
        if(pq.isEmpty()){
            return 0;
        }

        // Step 4: If one stone left, return its weight
        return pq.poll();
    }
}
