class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return minSpeedEating(piles,h);
    }
    public static int minSpeedEating(int[] piles,int h){
        int minSpeed=1;

        int maxSpeed=0;
        for(int a:piles){
            maxSpeed=Math.max(maxSpeed,a);
        }
        while(minSpeed<maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            
            if(CanEat(piles,h,mid)){
                maxSpeed=mid;
            }else{
                minSpeed=mid+1;
            }
            
        }
        return minSpeed;
    }
    public static boolean CanEat(int[] piles,int h,int speed){
        int hours=0;
        for(int a: piles){
            hours+=(int) Math.ceil((double)a/speed);
        }
        return hours<=h;
    }
}