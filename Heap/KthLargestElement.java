class Solution {
    public int findKthLargest(int[] nums, int k) {

        // Create a Min Heap (PriorityQueue)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // STEP 1: Insert first k elements into the heap
        for(int i = 0; i < k; i++){

            // Add first k elements
            pq.add(nums[i]);
        }

        // Now the heap contains k elements
        // The smallest among them is at the top

        // STEP 2: Process remaining elements
        for(int i = k; i < nums.length; i++){

            // If current element is greater than the smallest in heap
            if(nums[i] >= pq.peek()){

                // Remove the smallest element
                pq.poll();

                // Add the current element
                pq.add(nums[i]);
            }
        }

        // The heap now contains the k largest elements
        // The smallest among them is the kth largest element
        return pq.peek();
    }
}
