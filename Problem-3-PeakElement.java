/*
 * Uses binary search to find a peak element — an element greater than its neighbors.
 * If mid is greater than mid+1, the peak lies on the left; else, it lies on the right.
 * Guaranteed to find a peak in O(log n) due to the nature of the slope.
 */

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        // Edge case: only one element
        if (nums.length == 1)
            return 0;

        // Check if the first element is a peak
        if (nums[0] > nums[1])
            return 0;

        // Check if the last element is a peak
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        int i = 1;
        int j = nums.length - 2;

        // Binary search to find a peak
        while (i < j) {
            int mid = (i + j) / 2;

            // If mid is greater than the next element, peak is to the left (including mid)
            if (nums[mid] > nums[mid + 1])
                j = mid;
            // Otherwise, peak is to the right
            else
                i = mid + 1;
        }

        // i (or j) will point to a peak element
        return i;
    }
}
