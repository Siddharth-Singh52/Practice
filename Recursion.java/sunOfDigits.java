class Solution {
    static int sumOfDigits(int n) {
        // code here
        if(n == 0) {
            return 0;
        }
        
        int digit = n%10;
        int res = sumOfDigits(n/10);
        return res + digit;
    }
}
