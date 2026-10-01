class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            
            return 1.0 / Pow(x, -N);
        }
        return Pow(x, N);
    }

    public static double Pow(double x, long n) {
        if (n == 0) return 1.0;
        double half = Pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}