class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
    
        long a= Math.abs((long) dividend);
        long b= Math.abs((long) divisor);

        long low=0;
        long high=a;
        long ans=0;
        
        

        while(low<=high){
            long mid=low+((high-low)>>1);
            long temp=0;
            long x=b;
            long n=mid;
            while(n>0){
                if((n&1)==1){
                    temp+=x;
                }
                x+=x;
                n>>=1;
            }
            if(mid==0 || temp<=a){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if((dividend<0)!=(divisor<0)){
            ans=-ans;
        }
        return (int)ans;
    }
}