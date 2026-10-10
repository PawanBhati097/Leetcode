import java.util.Arrays;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max=0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max=Math.max(max,diff[i]);
        }
        
        long k = (long) k1 + k2;
        
        int[] freq=new int[max+1];
        for(int i=0;i<n;i++){
            freq[diff[i]]++;
        }

        for(int i=max;k>0&&i>0;i--){
            if (freq[i] == 0) continue;
            int min=(int)Math.min(freq[i],k);
            freq[i]-=min;
            freq[i-1]+=min;
            k-=min;
        }

        // while (k > 0) {
        //     Arrays.sort(diff);
        //     if (diff[n - 1] == 0) break;   
        //     diff[n - 1] -= 1;
        //     k--;
        // }
        
       long sum = 0;
        for (int d = 0; d < freq.length; d++) {
        sum += freq[d] * (long) d * d;
        }
        return sum;
    }
}