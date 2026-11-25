import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 100_003L;
    private static final long BASE2 = 100_019L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int lo = 1, hi = n, ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUniqueSubarrayOfLength(nums, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUniqueSubarrayOfLength(int[] nums, int k) {
        int n = nums.length;
        if (k <= 0 || k > n) return false;

        long pow1 = 1, pow2 = 1;
        for (int i = 1; i < k; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        long h1 = 0, h2 = 0;
        for (int i = 0; i < k; i++) {
            long val = nums[i] + 1L;
            h1 = (h1 * BASE1 + val) % MOD1;
            h2 = (h2 * BASE2 + val) % MOD2;
        }

        Map<Long, Integer> freq = new HashMap<>();
        long key = (h1 << 32) ^ h2;
        freq.put(key, 1);

        for (int i = k; i < n; i++) {
            long outVal = nums[i - k] + 1L;
            long inVal = nums[i] + 1L;

            h1 = ((h1 - (outVal * pow1) % MOD1 + MOD1) % MOD1 * BASE1 + inVal) % MOD1;
            h2 = ((h2 - (outVal * pow2) % MOD2 + MOD2) % MOD2 * BASE2 + inVal) % MOD2;

            key = (h1 << 32) ^ h2;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) return true;
        }
        return false;
    }
}
