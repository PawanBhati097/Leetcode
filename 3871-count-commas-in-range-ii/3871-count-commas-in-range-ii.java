class Solution {
    public long countCommas(long n) {  // Changed to long
        if (n < 1000) {  // Check value, not digits
            return 0;
        }
        
        long total = 0;
        long start = 1000;
        int commas = 1;
        
        while (start <= n) {
            long end = Math.min(n, start * 1000 - 1);
            total += commas * (end - start + 1);
            start *= 1000;
            commas++;
        }
        
        return total;
    }
}