class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Create triplet and add to ll
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[left]);
                    a.add(nums[right]);
                    ll.add(a);
                    
                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }
        return ll;
    }
}