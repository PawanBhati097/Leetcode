class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        
        // Try all possible translations
        for (int dx = -(n - 1); dx <= n - 1; dx++) {
            for (int dy = -(n - 1); dy <= n - 1; dy++) {
                int overlap = 0;
                
                // Count overlapping 1s
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // img1[i][j] moves to position (i+dx, j+dy) in img2's frame
                        int ni = i + dx;
                        int nj = j + dy;
                        
                        // Check if the new position is within bounds
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            if (img1[i][j] == 1 && img2[ni][nj] == 1) {
                                overlap++;
                            }
                        }
                    }
                }
                
                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }
        
        return maxOverlap;
    }
}