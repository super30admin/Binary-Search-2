// I used two binary searches to find the first and last occurrence of the target.
// The first search finds the leftmost index where target occurs, checking if it's the start or not preceded by the same value.
// The second search finds the rightmost index, ensuring it's the end or not followed by the same value.

// Time Complexity : O(log n) — Binary Search twice
// Space Complexity : O(1) — constant space
// Did this code successfully run on Leetcode : Yes


public class FirstLastSorted {
    
    // Main function to find first and last occurrence of target
    public int[] searchRange(int[] nums, int target) {
        // Find the first occurrence
        int first = binarySearchFirst(nums, 0, nums.length - 1, target);
        
        // If first is not found, target doesn't exist
        if (first == -1) {
            return new int[] { -1, -1 };
        }

        // Now find the last occurrence starting from first index
        int last = binarySearchLast(nums, first, nums.length - 1, target);

        return new int[] { first, last };
    }

    // Helper to find first occurrence using Binary Search
    public int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // Check if it's the first occurrence
                if (mid == low || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1; // Continue searching on the left
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // Target not found
    }

    // Helper to find last occurrence using Binary Search
    public int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // Check if it's the last occurrence
                if (mid == high || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1; // Continue searching on the right
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // Target not found
    }
}
