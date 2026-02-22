class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        int a = arr.length;
        
        Arrays.sort(arr);
        
        int count = 0;
        
        for(int i = 0; i < a-2; i++){
            
            int left = i+1;
            int right = a-1;
            
            while(left < right){
                long total = arr[i] + arr[left] + arr[right];
                
                if(total >= sum){
                    right--;
                }
                
                else{
                    count = count+(right-left); // as it is gratest element and all other element will be smaller than it.
                    left++;
                }
            }
        }      
        return count;
    }
}
