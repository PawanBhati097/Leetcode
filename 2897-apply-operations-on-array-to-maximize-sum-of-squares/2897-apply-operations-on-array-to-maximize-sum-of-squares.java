class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        
        // Count occurrences of each bit position across all nums
        int[] cnt = new int[31];
        for (int x : nums) {
            for (int b = 0; b < 31; b++) {
                if ((x >> b & 1) == 1) cnt[b]++;
            }
        }
        
        // Build k numbers greedily: assign each bit to as many of the top k as possible
        long[] res = new long[k];
        for (int b = 30; b >= 0; b--) {
            int take = Math.min(k, cnt[b]);
            for (int i = 0; i < take; i++) {
                res[i] |= (1L << b);
            }
        }
        
        // Sum of squares
        long sum = 0;
        for (long v : res) {
            sum = (sum + (v % MOD) * (v % MOD)) % MOD;
        }
        return (int) sum;
    }
}