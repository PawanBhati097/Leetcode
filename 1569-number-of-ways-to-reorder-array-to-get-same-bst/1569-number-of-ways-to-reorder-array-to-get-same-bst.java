import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] fact;
    private long[] invFact;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Precompute factorials and inverse factorials for nCr calculations
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // The answer is the total ways minus 1 (excluding the original array itself)
        return (int) (ways(list) - 1 + MOD) % MOD;
    }

    private long ways(List<Integer> list) {
        if (list.size() <= 1) {
            return 1;
        }

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition into left and right subtrees
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        long leftWays = ways(left);
        long rightWays = ways(right);

        // Calculate combinations: (left.size() + right.size()) C (left.size())
        long combinations = nCr(left.size() + right.size(), left.size());

        return (((leftWays * rightWays) % MOD) * combinations) % MOD;
    }

    // nCr using precomputed factorials
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Fermat's Little Theorem for modular inverse
    private long modPow(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}