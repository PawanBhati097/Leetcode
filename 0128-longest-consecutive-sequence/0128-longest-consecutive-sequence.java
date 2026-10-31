class Solution {
    public int longestConsecutive(int[] nums) {
        return Longest_Consecutive(nums);
    }
    public static int Longest_Consecutive(int[] arr) {
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]); 
		}
		int ans=0;
		for (int i = 0; i < arr.length; i++) {
			int x=arr[i];
			if(set.contains(x)&& !set.contains(x-1)) {
				int c=0;
				while(set.contains(x)) {
					set.remove(x);
					x++;
					c++;
				}
				 ans=Math.max(ans, c);
			}
		}
		return ans;
	}
}