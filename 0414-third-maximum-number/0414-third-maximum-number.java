class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        int j = 0;  // Track position in arr
        
        // Store distinct elements in arr
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                arr[j] = nums[i];
                j++;
            }
        }
        
        // If less than 3 distinct elements, return maximum
        if (j < 3) {
            return arr[j - 1];
        }
        
        // Return third maximum
        return arr[j - 3];
    }
}