class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();

        // Start and end of the new interval that we want to insert
        int start2 = newInterval[0];
        int end2 = newInterval[1];

        // Traverse all existing intervals
        for(int i = 0; i < intervals.length; i++){
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];

            // Case 1: Current interval completely before newInterval
            // No overlap, so just add it to result
            if(end1 < start2){
                res.add(Arrays.asList(start1, end1));
            }

            // Case 2: Current interval completely after newInterval
            // Insert newInterval first, then treat current interval as new interval
            else if(start1 > end2){
                res.add(Arrays.asList(start2, end2));
                start2 = start1;
                end2 = end1;
            }

            // Case 3: Overlapping intervals
            // Merge the intervals by expanding newInterval
            else{
                start2 = Math.min(start1,start2);
                end2 = Math.max(end1, end2);
            }
        }

        // Add the last interval after finishing the loop
        res.add(Arrays.asList(start2, end2));

        int[][] ans = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }

        return ans;
    }
}
