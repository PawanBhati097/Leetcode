class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            if (diff[i] > max) max = diff[i];
        }
        
        // freq[d] = how many indices have diff == d
        long[] freq = new long[max + 1];
        for (int d : diff) freq[d]++;
        
        long k = (long) k1 + k2;
        
        // Reduce from largest level down, moving all elements at that level
        for (int d = max; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;
            long move = Math.min(k, freq[d]);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }
        
        long sum = 0;
        for (int d = 0; d <= max; d++) {
            sum += freq[d] * (long) d * d;
        }
        return sum;
    }
}