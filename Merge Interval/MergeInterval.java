import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting time / 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> res = new ArrayList<>();

        // Initialize first interval
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        // Traverse remaining intervals
        for(int i = 1; i < intervals.length; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            // If intervals overlap, merge them by updating end
            if(end1 >= start2){
                start1 = start1;
                end1 = Math.max(end1, end2);
                continue;
            }

            // If no overlap, store the previous merged interval
            res.add(Arrays.asList(start1, end1));

            // Start a new interval
            start1 = start2;
            end1 = end2;
        }

        // Add the last interval after loop finishes
        res.add(Arrays.asList(start1, end1));

        // Convert List<List<Integer>> to int[][]
        int[][] ans = new int[res.size()][2];

        for(int i = 0; i < res.size(); i++){
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }

        return ans;
    }
}
