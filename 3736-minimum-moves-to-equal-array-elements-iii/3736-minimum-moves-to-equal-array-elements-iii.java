class Solution {
    public int minMoves(int[] nums) {
        int n=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>n){
                n=nums[i];
            }
        }
            int a=0;
        for(int i=0;i<nums.length;i++){
            a+=(n-nums[i]);
        }
        
        return a;
    }
}