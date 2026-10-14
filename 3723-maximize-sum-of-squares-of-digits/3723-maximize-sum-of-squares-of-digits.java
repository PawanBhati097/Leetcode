class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Feasibility check
        if (sum < 1 || sum > 9 * num) {
            return "";
        }
        
        int q = sum / 9;      // number of 9s
        int r = sum % 9;      // remainder digit
        
        StringBuilder sb = new StringBuilder();
        
        // Add all 9s
        for (int i = 0; i < q; i++) {
            sb.append('9');
        }
        
        // Add remainder digit if non-zero
        if (r > 0) {
            sb.append((char)('0' + r));
        }
        
        // Fill remaining with zeros
        int remaining = num - sb.length();
        for (int i = 0; i < remaining; i++) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}