class Solution {
    public int minimizeSum(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        
        int c1 = a[n - 1] - a[2];     // change 2 smallest
        int c2 = a[n - 3] - a[0];     // change 2 largest
        int c3 = a[n - 2] - a[1];     // change 1 smallest & 1 largest
        
        return Math.min(c1, Math.min(c2, c3));
    }
}