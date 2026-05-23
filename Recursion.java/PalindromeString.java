class Solution {
    boolean isPalindrome(String s) {
        // code here
        int low = 0;
        int high = s.length()-1;
        
        boolean res = pal(s, low, high);
        return res;
    }
    
    boolean pal(String s,int low,int high){
        
        if(low >= high){
            return true;
        }
        
        if(s.charAt(low) != s.charAt(high)){
            return false;
        }
        
        return pal(s, low+1, high-1);
    }
}
