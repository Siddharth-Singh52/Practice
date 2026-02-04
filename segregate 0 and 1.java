class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int left = 0;
        int right = arr.length-1;
        
        while(left < right){
            
            if(arr[left] == 0 && arr[right] == 0){
                left++;
            }
            else if(arr[left] == 1 && arr[right] == 1){
                right--;
            }
            else if(arr[left] == 1 && arr[right] == 0){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                right--;
                left++;
            }
            else if(arr[left] == 0 && arr[right] == 1){
                left++;
            }
        }
    }
}
