class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    
    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                answer = mid;      // Save this position
                end = mid - 1;     // Go left to find first
            } 
            else if (nums[mid] < target) {
                start = mid + 1;   // Go right
            } 
            else {
                end = mid - 1;     // Go left
            }
        }
        return answer;
    }
    
    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer = -1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                answer = mid;      // Save this position
                start = mid + 1;   // Go right to find last
            } 
            else if (nums[mid] < target) {
                start = mid + 1;   // Go right
            } 
            else {
                end = mid - 1;     // Go left
            }
        }
        return answer;
    }
}