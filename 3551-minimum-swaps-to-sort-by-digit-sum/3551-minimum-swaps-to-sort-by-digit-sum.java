class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // 1. Order of indices in the sorted target (by digit sum, then value).
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> {
            int sa = digitSum(nums[a]), sb = digitSum(nums[b]);
            return sa != sb ? sa - sb : Integer.compare(nums[a], nums[b]);
        });

        // 2. targetPos[value] = position that value must occupy after sorting.
        //    Values are distinct, so a HashMap is safe.
        Map<Integer, Integer> targetPos = new HashMap<>(n * 2);
        for (int pos = 0; pos < n; pos++) targetPos.put(nums[order[pos]], pos);

        // 3. For each current index i, where does its element need to go?
        int[] next = new int[n];
        for (int i = 0; i < n; i++) next[i] = targetPos.get(nums[i]);

        // 4. Minimum swaps = sum over cycles of (cycleLength - 1).
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || next[i] == i) continue;
            int len = 0;
            for (int j = i; !visited[j]; j = next[j]) {
                visited[j] = true;
                len++;
            }
            swaps += len - 1;
        }
        return swaps;
    }

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) { s += x % 10; x /= 10; }
        return s;
    }
}