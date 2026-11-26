class Solution {
    public boolean canAliceWin(int n) {
        int r = 10;
        boolean a = true;
        while (n >= r) {
            n -= r--;
            a = !a;
        }
        return !a;
    }
}