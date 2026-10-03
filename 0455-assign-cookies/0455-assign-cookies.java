class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;   // pointer for children
        int cookie = 0;  // pointer for cookies

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // This cookie satisfies this child
                child++;
            }
            // Move to next cookie either way
            cookie++;
        }

        return child;
    }
}