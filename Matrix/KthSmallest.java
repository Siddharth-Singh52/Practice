class Solution {

    // This function counts how many elements in the matrix are less than or equal to the given guess value
    int fun(int[][] matrix, int m, int n, int guess){ // m = rows, n = cols
        int row = m-1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < n){
            if(matrix[row][col] > guess){
                row--;
            }
            else{
                // If current element <= guess,then all elements above it in same column are also <= guess
                count = count + row+1;
                col++;
            }
        }
        return count;
    }


    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Binary search range is from smallest element to largest element in the matrix
        int low = matrix[0][0]; // smallest element
        int high = matrix[m-1][n-1]; // largest element
        int res = -1;

        while(low <= high){
            int guess = low+(high-low)/2;

            int ans = fun(matrix, m, n, guess);

            // If fewer than k elements are <= guess, we need a bigger number
            if(ans < k){
                low = guess+1;
            }
            else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }
}
