class Solution {

    // Pair class to store character and its frequency
    class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {

        // Edge case:
        // If k == 1, har character turant remove ho jayega
        if(k == 1){
            return "";
        }
        int n = s.length();

        // Stack to store (character, frequency) pairs
        Stack<Pair> stack = new Stack<>();

        // Traverse the String
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Case 1:
            // Stack empty hai → naya character push karo
            if (stack.isEmpty()) {
                stack.push(new Pair(c, 1));
            } 
            // Case 2:
            // Current character different hai → new group start
            else if (stack.peek().ch != c) {
                stack.push(new Pair(c, 1));
            } 
            // Case 3:
            // Same character hai AND count < k-1 → frequency increase karo
            else if (stack.peek().count < k - 1) {
                Pair p = stack.peek();
                p.count++;
            } 
            // Case 4:
            // Same character hai AND count == k-1
            // Matlab ab k-th occurrence aa gaya → pura group remove
            else {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();

        // Stack se elements pop karte waqt order reverse ho jata hai (LIFO)
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            // Har character ko uski frequency ke according append karo
            for (int i = p.count; i > 0; i--) {
                res.append(p.ch);
            }
        }
        // Kyunki stack ne reverse kar diya hai,
        // hum final string ko reverse karke original order laate hain
        return res.reverse().toString();
    }
}
