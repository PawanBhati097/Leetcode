class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0;
        long evenCount = 1; // 0 is an even prefix sum
        long currentSum = 0;
        long totalSubarrays = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {
            currentSum += num;

            if (currentSum % 2 == 1) {
                // If current prefix sum is odd, add the count of previous even prefix sums
                totalSubarrays = (totalSubarrays + evenCount) % MOD;
                oddCount++;
            } else {
                // If current prefix sum is even, add the count of previous odd prefix sums
                totalSubarrays = (totalSubarrays + oddCount) % MOD;
                evenCount++;
            }
        }

        return (int) totalSubarrays;
    }
}