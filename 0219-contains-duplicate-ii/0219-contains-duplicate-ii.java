class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create array of pairs [value, index]
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Sort by value then by index
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // Check adjacent equal values
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] == pairs[i-1][0]) {
                if (pairs[i][1] - pairs[i-1][1] <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}