class Solution {
    public int[] productExceptSelf(int[] nums) {
        return Product(nums);
    }
    public static int[] Product(int[] arr){
        int n=arr.length;
        //prefix
        int[] left=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*arr[i-1];
        }
        //suffix
        int[] right=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*arr[i+1];
        }
        //calculation
        for(int i=0;i<n;i++){
            left[i]=right[i]*left[i];
        }
        return left;
    }
}