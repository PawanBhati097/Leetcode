class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Strategy 1: Buy only Type 1 and Type 2 items
        long costOnlySingles = 1L * need1 * cost1 + 1L * need2 * cost2;
        
        // Strategy 2: Buy only Type 3 items up to the maximum need
        long costOnlyBundles = 1L * costBoth * Math.max(need1, need2);
        
        // Strategy 3: Buy min(need1, need2) Type 3 items and fill the rest with singles
        long minNeed = Math.min(need1, need2);
        long costMixed = 1L * costBoth * minNeed 
                       + 1L * (need1 - minNeed) * cost1 
                       + 1L * (need2 - minNeed) * cost2;
        
        // Return the minimum of all three strategies
        return Math.min(costOnlySingles, Math.min(costOnlyBundles, costMixed));
    }
}