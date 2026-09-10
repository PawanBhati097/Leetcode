class Solution {
    public int arrangeCoins(int n) {
        long lo = 0;
        long hi = n;
        
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;
            
            if (coinsNeeded == n) {
                return (int) mid;
            } else if (coinsNeeded < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return (int) hi;  
    }
}