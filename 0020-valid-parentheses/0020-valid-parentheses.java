class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        return isValidHelper(s, 0, stack);
    }
    
    public boolean isValidHelper(String s, int index, Stack<Character> stack) {
        if (index == s.length()) {
            return stack.isEmpty();
        }
        
        char c = s.charAt(index);
        
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
            return isValidHelper(s, index + 1, stack);
        } else {
            if (stack.isEmpty()) {
                return false;
            }
            
            char open = stack.pop();
            if (!isMatching(open, c)) {
                return false;
            }
            
            return isValidHelper(s, index + 1, stack);
        }
    }
    
    public boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}