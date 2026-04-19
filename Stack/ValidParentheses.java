class Solution {
    public boolean isValid(String s) {
        
        // Stack use kar rahe hain to track opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character of the string
        for(int i = 0; i < s.length(); i++){
            
            // Agar opening bracket hai → push into stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                // Agar closing bracket mila aur stack empty hai → invalid
                if(stack.isEmpty()){
                    return false;
                }

                // Check matching pair for '('
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop(); // valid pair → remove from stack
                }
                // Check matching pair for '{'
                else if(stack.peek() == '{' && s.charAt(i) == '}'){
                    stack.pop();
                }
                // Check matching pair for '['
                else if(stack.peek() == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }
                else{
                    // Mismatch case → invalid string
                    return false;
                }
            }
        }

        // Final check:
        // Agar stack empty hai → all brackets matched
        // Agar kuch bacha hai → invalid
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
