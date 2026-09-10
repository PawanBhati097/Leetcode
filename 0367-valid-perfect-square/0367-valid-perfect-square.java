class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) {
            return true;
        }
        return isPossible(num);
    }
    
    public static boolean isPossible(int n) {
        int lo = 0;
        int hi = n / 2;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid; 
            
            if (square == n) {
                return true;
            } else if (square > n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return false;
    }
}