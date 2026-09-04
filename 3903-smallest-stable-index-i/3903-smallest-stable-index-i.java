class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            int a = Largest(0, i, nums);
            int b = Smallest(i, nums.length - 1, nums);  
            int diff = a - b;
            if(diff <= k) {  
                return i;    
            }
        }
        return -1;  
    }
    
    public static int Largest(int start, int end, int[] nums) {
        int large = nums[start];  
        for(int i = start; i <= end; i++) {
            if(nums[i] > large) {
                large = nums[i];
            }
        }
        return large;
    }
    
    public static int Smallest(int start, int end, int[] nums) {
        int small = nums[start];  
        for(int i = start; i <= end; i++) {  
            if(nums[i] < small) {
                small = nums[i];
            }
        }
        return small;
    }
}