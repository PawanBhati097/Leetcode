class Solution {
    public int countCommas(int n) {
       int a=n; 
       if(a<1000){
        return 0;
       }
       return n+1-1000;
    }
    // public static int Count(int n){
    //     int c=0;
    //     while(n>0){
    //         c++;
    //         n=n/10;
    //     }
    //     return c;
    // }
}