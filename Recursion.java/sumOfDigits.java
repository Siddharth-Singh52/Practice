class Solution {
    static int sumOfDigits(int n) {
        // code here
        // base case
        if(n == 0) {
            return 0;
        }

        // small problem
        int digit = n%10;
        int res = sumOfDigits(n/10);
        return res + digit;
    }
}
