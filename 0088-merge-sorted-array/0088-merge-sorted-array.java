class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Merge(nums1,m,nums2,n);
    }
    public static void Merge(int[] arr1,int n,int[] arr2,int m){
        int i=0,k=0,j=0;
        int[] arr3=new int[m+n];
            while(i<n&&j<m){
                if(arr1[i]<arr2[j]){
                    arr3[k++]=arr1[i++];
                }else{
                    arr3[k++]=arr2[j++];
                }
            }
            while(i<n){
                arr3[k++]=arr1[i++];
            }
            while(j<m){
                arr3[k++]=arr2[j++];
            }
        for(int l=0;l<arr3.length;l++){
            arr1[l]=arr3[l];
        }
    }

}