import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        int INF = 1_000_000;

        // Step 1: Precompute minimum changes to make s[i..j] a semi-palindrome
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getMinChanges(s, i, j);
            }
        }

        // Step 2: DP to partition s into k substrings
        // dp[p][i] = min changes to partition prefix of length i into p parts
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Base case: 1 partition
        for (int i = 2; i <= n; i++) {
            dp[1][i] = cost[0][i - 1];
        }

        // Fill DP table for 2 to k partitions
        for (int p = 2; p <= k; p++) {
            // Each partition needs at least length 2, so i starts at 2 * p
            for (int i = 2 * p; i <= n; i++) {
                // Split point j: prefix of length j into p-1 parts, s[j..i-1] as p-th part
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j][i - 1]);
                }
            }
        }

        return dp[k][n];
    }

    private int getMinChanges(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;

        // Test all valid divisors d (1 <= d < len)
        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int changes = 0;
            // Check each of the d groups
            for (int offset = 0; offset < d; offset++) {
                int left = start + offset;
                int right = end - d + 1 + offset;
                
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}