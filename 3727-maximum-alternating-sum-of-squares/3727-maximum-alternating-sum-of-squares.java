class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // Sort by absolute value
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> Math.abs(a) - Math.abs(b));
        
        long score = 0;
        int addCount = (n + 1) / 2; // number of add positions
        
        // Smallest elements go to subtract positions (odd indices)
        // Largest elements go to add positions (even indices)
        // After sorting by abs value ascending:
        // - First floor(n/2) elements go to subtract positions
        // - Last ceil(n/2) elements go to add positions
        
        int subtractCount = n / 2;
        
        // Subtract the smallest ones
        for (int i = 0; i < subtractCount; i++) {
            long val = Math.abs((long) arr[i]);
            score -= val * val;
        }
        
        // Add the largest ones
        for (int i = subtractCount; i < n; i++) {
            long val = Math.abs((long) arr[i]);
            score += val * val;
        }
        
        return score;
    }
}