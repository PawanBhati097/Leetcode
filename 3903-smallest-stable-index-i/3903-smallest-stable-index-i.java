class Solution {
    public int firstStableIndex(int[] nums, int k) {
        //prefix-max
        int n=nums.length;
        int[] left=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],nums[i]);
        }
        //suffix-min
        int[] right=new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.min(right[i+1],nums[i]);
        }
        //calculation
        int j=0;
        for(int i=0;i<n;i++){
            if(left[i]-right[i]<=k){
                return i;
            }
        }
        return -1;
    }
}