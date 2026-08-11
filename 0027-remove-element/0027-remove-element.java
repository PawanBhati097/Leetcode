class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
       int i=0;
       int j=nums.length-1;
       while(i<j){
        if(nums[i]!=val){
            i++;
        }
        if(nums[i]==val){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
        }
        
       }
        for(int k=0;k<nums.length;k++){
            if(nums[k]!=val){
                count++;
            }
            else{
                return count;
            }
        }
        return count;
    }
}