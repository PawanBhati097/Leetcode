class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        
        // Step 1: Find last position of each letter
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Go through string and cut
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int lastPos = last[letter - 'a'];
            
            // Extend the current part's end
            if (lastPos > end) {
                end = lastPos;
            }
            
            // If we reached the end of current part
            if (i == end) {
                int size = i - start + 1;
                result.add(size);
                start = i + 1;
            }
        }
        
        return result;
    }
}