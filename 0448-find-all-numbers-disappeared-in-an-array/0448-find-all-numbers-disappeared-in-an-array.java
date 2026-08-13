class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        
        // Mark numbers that exist
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as negative
            }
        }
        
        // Find missing numbers (positive numbers are missing)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ll.add(i + 1);
            }
        }
        
        return ll;
    }
}