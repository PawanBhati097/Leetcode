class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        return max_path(nums1, nums2);
    }
    
    public static int max_path(int[] a1, int[] a2) {
        long sum1 = 0;
        long sum2 = 0;
        long ans = 0;
        int i = 0, j = 0;
        int n = a1.length;
        int m = a2.length;
        long mod = 1000000007;
        
        // Traverse both arrays simultaneously
        while (i < n && j < m) {
            if (a1[i] < a2[j]) {
                sum1 += a1[i];
                i++;
            } else if (a1[i] > a2[j]) {
                sum2 += a2[j];
                j++;
            } else {
                // Common element found - add to both sums
                sum1 += a1[i];
                sum2 += a2[j];
                
                // Take maximum of both paths and add to answer
                ans += Math.max(sum1, sum2);
                
                // Reset sums for next segment (don't include common element again)
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        
        // Add remaining elements from array1
        while (i < n) {
            sum1 += a1[i];
            i++;
        }
        
        // Add remaining elements from array2
        while (j < m) {
            sum2 += a2[j];
            j++;
        }
        
        // Add the maximum of the remaining sums
        ans += Math.max(sum1, sum2);
        
        return (int)(ans % mod);
    }
}