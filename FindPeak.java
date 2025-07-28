// I used Binary Search to find a peak element in the array.
// A peak element is one which is greater than its neighbors.
// The idea is to move towards the side which has a greater neighbor,because there must be at least one peak on that side.

// Time Complexity : O(log n) — since we're doing binary search
// Space Complexity : O(1) — constant space usage
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is a peak element
            boolean isLeftSmaller = (mid == 0 || nums[mid] > nums[mid - 1]);
            boolean isRightSmaller = (mid == nums.length - 1 || nums[mid] > nums[mid + 1]);

            if (isLeftSmaller && isRightSmaller) {
                return mid; // Found a peak
            }
            // If right neighbor is greater, then move right
            else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            }
            // Else move left
            else {
                high = mid - 1;
            }
        }

        return -1; // Should never reach here if input is valid
    }
}
