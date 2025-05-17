/*
 * Uses binary search to find the minimum element in a rotated sorted array.
 * 1. At each step, check if mid is smaller than both neighbors — if so, it's the minimum.
 * 2. If mid > right, the minimum lies in the right half; otherwise, it's in the left half.
 */

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * Linearly find the pivot point (where the rotation happens), then rotate the array back to sorted order using reverse operations.
 * The minimum element will end up at index 0 after full reversal.
 * This approach takes O(n) time in the worst case due to the initial linear scan and reversal steps.
 */

class Solution {
    public int findMin(int[] nums) {
        // If there's only one element, return it
        if (nums.length == 1)
            return nums[0];

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;

            // Check if mid is the minimum element
            if (nums[mid] < nums[mid + 1] && mid != 0 && nums[mid] < nums[mid - 1])
                return nums[mid];

            // If mid element is greater than the rightmost element,
            // the minimum must be in the right half
            else if (nums[mid] > nums[r])
                l = mid + 1;

            // Otherwise, the minimum lies in the left half
            else
                r = mid - 1;
        }
        // Return the minimum element
        return nums[l];
    }
}
