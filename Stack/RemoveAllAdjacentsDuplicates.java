class Solution {
    public String removeDuplicates(String s) {

        // Stack use kar rahe hain to keep track of characters
        // LIFO property helps in removing adjacent duplicates easily
        Stack<Character> stack = new Stack<>();
        
        // StringBuilder final result banane ke liye (efficient string handling)
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){

            // Agar stack empty nahi hai aur current character
            // stack ke top ke equal hai → duplicate mila
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop();  // Duplicate pair remove karne ke liye pop
            }
            else{
                stack.push(s.charAt(i)); // Agar duplicate nahi hai → character ko stack me push karo
            }
        }

        // Ab stack me final characters bach gaye hain
        // But order reverse hoga (LIFO), isliye pop karke res me daal rahe hain
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        // Reverse karte hain kyuki stack se reverse order me nikla tha
        // toString() convert karta hai StringBuilder → String
        return res.reverse().toString();
    }
}
