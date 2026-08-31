class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        
        // Combine difficulty and profit
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        
        int max = 0;
        int j = 0;
        int answer = 0;
        
        for (int w : worker) {
            // Update max profit for all jobs this worker can do
            while (j < n && jobs[j][0] <= w) {
                max = Math.max(max, jobs[j][1]);
                j++;
            }
            answer += max;
        }
        
        return answer;
    }
}