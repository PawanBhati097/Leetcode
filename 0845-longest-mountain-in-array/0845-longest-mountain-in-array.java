class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;
        int i = 1;
        
        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                // Found a peak, expand left and right
                int left = i - 1;
                int right = i + 1;
                
                // Expand left while strictly increasing
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                
                // Expand right while strictly decreasing
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                
                // Update longest
                int length = right - left + 1;
                longest = Math.max(longest, length);
                
                // Move i to right (skip processed elements)
                i = right;
            } else {
                i++;
            }
        }
        
        return longest;
    }
}