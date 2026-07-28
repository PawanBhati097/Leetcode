class Solution {
    public boolean isPalindrome(int x) {
        return pai(x);
    }
    public static boolean pai(int n) {
		int i=reverse(n,0);
        if(n<0){
            return false;
        }
		else if(i==n) {
			return true;
		}else {
			return false;
		}
	}
	public static int reverse(int n,int i) {
		if(n==0) {
			return i;
		}
		return reverse(n/10,i*10+n%10);
	}
}