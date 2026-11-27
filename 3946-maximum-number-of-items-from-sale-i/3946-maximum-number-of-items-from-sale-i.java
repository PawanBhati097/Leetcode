import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeFrom = new int[n];

        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    cnt++;
                }
            }
            freeFrom[i] = cnt;
        }

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> {
            if (items[b][1] != items[a][1]) {
                return Integer.compare(items[b][1], items[a][1]);
            }
            return Integer.compare(a, b);
        });

        final int NEG_INF = -1_000_000_000;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG_INF);
        dp[0] = 0;

        int ans = 0;
        for (int idx : order) {
            int p = items[idx][1];
            int w = 1 + freeFrom[idx];
            if (p <= budget) {
                for (int c = budget - p; c >= 0; c--) {
                    if (dp[c] != NEG_INF) {
                        int rem = budget - (c + p);
                        int total = dp[c] + w + (rem / p);
                        if (total > ans) {
                            ans = total;
                        }
                    }
                }
                for (int c = budget; c >= p; c--) {
                    if (dp[c - p] != NEG_INF && dp[c - p] + w > dp[c]) {
                        dp[c] = dp[c - p] + w;
                    }
                }
            }
        }

        return ans;
    }
}