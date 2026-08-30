class Solution {
    public void nextPermutation(int[] nums) {
        Permutation(nums);
    }
    public static void Permutation(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the first decreasing element from right
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // Step 2: If no such element exists, array is in descending order
        if (i < 0) {
            // Reverse the entire array (sort ascending)
            reverse(arr, 0, n - 1);
            return;
        }
        
        // Step 3: Find the smallest element greater than arr[i] from the right
        int j = n - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        
        // Step 4: Swap arr[i] and arr[j]
        swap(arr, i, j);
        
        // Step 5: Reverse the suffix starting from i+1
        reverse(arr, i + 1, n - 1);
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}