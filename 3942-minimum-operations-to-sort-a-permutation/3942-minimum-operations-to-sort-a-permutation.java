class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i;
        
        int ans = Integer.MAX_VALUE;
        
        // Case 1: sorted is rotation of nums (left shift k1)
        int k1 = findRotation(nums, n);
        if (k1 != -1) {
            ans = Math.min(ans, Math.min(k1, 2 + n - k1));
        }
        
        // Case 2: sorted is rotation of reverse(nums)
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) rev[i] = nums[n - 1 - i];
        int k2 = findRotation(rev, n);
        if (k2 != -1) {
            ans = Math.min(ans, 1 + Math.min(k2, n - k2));
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    // Returns k if arr rotated left by k equals [0,1,...,n-1], else -1
    private int findRotation(int[] arr, int n) {
        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) { pos0 = i; break; }
        }
        if (pos0 == -1) return -1;
        // check arr[pos0 + i] == i for all i
        for (int i = 0; i < n; i++) {
            if (arr[(pos0 + i) % n] != i) return -1;
        }
        return pos0;
    }
}