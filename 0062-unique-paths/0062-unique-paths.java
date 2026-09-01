class Solution {
    int[][] memo;
    
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return MazePath(0, 0, m-1, n-1);
    }
    
    public int MazePath(int cr, int cc, int er, int ec) {
        if (cr == er && cc == ec) {
            return 1;
        }
        if (cr > er || cc > ec) {
            return 0;
        }
        
        // Check if already computed
        if (memo[cr][cc] != 0) {
            return memo[cr][cc];
        }
        
        // Store result in memo
        memo[cr][cc] = MazePath(cr+1, cc, er, ec) + MazePath(cr, cc+1, er, ec);
        return memo[cr][cc];
    }
}