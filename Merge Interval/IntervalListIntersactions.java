class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        // Two pointers for traversing both interval lists
        int i = 0;
        int j = 0;
        
        List<List<Integer>> res = new ArrayList<>();

        // Traverse both lists until one of them finishes
        while(i < firstList.length && j < secondList.length){

            // Current interval from first list
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            // Current interval from Second list
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // Case 1: first interval starts before second
            if(start1 < start2){

                // Check if intervals overlap
                if(end1 >= start2){

                    // Intersection interval
                    int start = Math.max(start1, start2);
                    int end = Math.min(end1, end2);
                    res.add(Arrays.asList(start, end));
                }
            }
            // Case 2: second interval starts before first
            else{
                if(end2 >= start1){
                    int start = Math.max(start1, start2);
                    int end = Math.min(end1, end2);
                    res.add(Arrays.asList(start, end));
                }
            }

            // Move the pointer of the interval which ends first
            if(end1 <= end2){
                i++;
            }
            else{
                j++;
            }
        }

        // Convert List<List<Integer>> to int[][]
        int[][] ans = new int[res.size()][2];

        for(int k = 0; k < res.size(); k++){
            ans[k][0] = res.get(k).get(0);
            ans[k][1] = res.get(k).get(1);
        }

        return ans;
    }
}
