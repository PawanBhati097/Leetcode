class Solution {
    public int maxArea(int[] height) {
        return max_Area(height);
    }
     public static int max_Area(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        
        // TWO POINTER APPROACH
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int width = right - left;
            int h = Math.min(arr[left], arr[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);
            
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}