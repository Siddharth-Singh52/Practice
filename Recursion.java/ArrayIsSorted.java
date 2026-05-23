class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        int n = arr.length-1;
        return fun(arr, n, 0);
    }
    
    boolean fun(int[] arr, int n, int i){
        // Base Case
        if(i == n || i == n-1){
            return true;
        }

      // Small Problem
        if(arr[i] > arr[i+1]){
            return false;
        }
        
        return fun(arr, n, i+1);
    }
}
