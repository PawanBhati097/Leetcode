class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] sum;
    private long[] sumSq;
    private long[] lazy;
    private int n;
    
    public int sumCounts(int[] nums) {
        n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];
        
        // Track previous occurrence of each value
        Map<Integer, Integer> lastOccur = new HashMap<>();
        
        long answer = 0;
        
        for (int j = 0; j < n; j++) {
            int prev = lastOccur.getOrDefault(nums[j], -1);
            // Add 1 to D[i] for i in [prev+1, j]
            update(1, 0, n - 1, prev + 1, j, 1);
            lastOccur.put(nums[j], j);
            
            // Query sumSq over [0, j]
            answer = (answer + query(1, 0, n - 1, 0, j)) % MOD;
        }
        
        return (int) answer;
    }
    
    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        update(2*node, l, mid, ql, qr, val);
        update(2*node+1, mid+1, r, ql, qr, val);
        pullUp(node);
    }
    
    private long query(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return sumSq[node];
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        return (query(2*node, l, mid, ql, qr) + query(2*node+1, mid+1, r, ql, qr)) % MOD;
    }
    
    private void apply(int node, int l, int r, long val) {
        long cnt = r - l + 1;
        // new sumSq = sumSq + 2*val*sum + val^2*cnt
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + val % MOD * val % MOD * (cnt % MOD) % MOD) % MOD;
        sum[node] = (sum[node] + val % MOD * (cnt % MOD)) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }
    
    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0 && l != r) {
            int mid = (l + r) / 2;
            apply(2*node, l, mid, lazy[node]);
            apply(2*node+1, mid+1, r, lazy[node]);
            lazy[node] = 0;
        }
    }
    
    private void pullUp(int node) {
        sum[node] = (sum[2*node] + sum[2*node+1]) % MOD;
        sumSq[node] = (sumSq[2*node] + sumSq[2*node+1]) % MOD;
    }
}