class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1; // 4
        int n = matrix[0].length-1; // 4
        int row = m;
        int col = 0;

        while(row >= 0 && col <= n){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                row--;
            }
            else{
                col++;
            }
        }
        return false;
    }
}
