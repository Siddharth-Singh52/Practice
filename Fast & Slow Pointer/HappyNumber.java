class Solution {
    public boolean isHappy(int n) {
    
        int slow = n;
        int fast = n;

        while(fast != 1){
            slow = square(slow); // it will give sum of square one time 2 -> 4
            fast = square(square(fast)); // 2 -> 4 then again 4 -> 16

            // If both pointers meet (not at 1), a cycle is detected
            // which means number is NOT a happy number
            if(slow == fast && slow != 1){
                return false;
            }
        }

        // If fast reaches 1, number is a happy number
        return true;
    }

    public int square(int num){
            int sum = 0;
            while(num > 0){
                int digit = num%10;
                num = num/10;
                sum += digit*digit;
            }
            return sum;
        }
}
