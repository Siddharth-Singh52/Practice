class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(tokens[i].equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            }
            else if(tokens[i].equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            }
            else if(tokens[i].equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            }
            else if(tokens[i].equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
