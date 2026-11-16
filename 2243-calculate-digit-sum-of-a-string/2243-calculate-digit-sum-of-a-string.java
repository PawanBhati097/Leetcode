class Solution {
    public String digitSum(String s, int k) {
        // Continue rounds while the string length is greater than k
        while (s.length() > k) {
            StringBuilder nextRound = new StringBuilder();
            
            // Step through the string in chunks of size k
            for (int i = 0; i < s.length(); i += k) {
                int sum = 0;
                int end = Math.min(i + k, s.length());
                
                // Sum the digits in the current group
                for (int j = i; j < end; j++) {
                    sum += s.charAt(j) - '0';
                }
                
                // Append the group's sum to the new string
                nextRound.append(sum);
            }
            
            // Update s for the next round
            s = nextRound.toString();
        }
        
        return s;
    }
}