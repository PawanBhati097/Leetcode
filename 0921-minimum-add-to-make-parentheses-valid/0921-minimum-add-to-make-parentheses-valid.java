class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;   // unmatched '('
        int moves = 0;  // insertions needed for unmatched ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else { // c == ')'
                if (open > 0) {
                    open--;      // matches an earlier '('
                } else {
                    moves++;     // no '(' to match → must insert one
                }
            }
        }
        return moves + open; // leftover '(' each need a ')'
    }
}