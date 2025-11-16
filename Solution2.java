// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Time complexity: O(logN)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I missed to handle the case where nums.length = 1. Fixed it after checking the test case.
class Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 1) {
            // The only element in the array is the least element.
            return nums[0];
        }
        // Array is sorted and unrotated, return element in low index.
        if (nums[low] < nums[high]) {
            return nums[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // If two adjacent elements are not sorted, return the least element.
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }
            // Least element is always in unsorted half of the array.
            if (nums[low] <= nums[mid]) {
                // Left array is sorted, move right.
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                // Right array is sorted, move left.
                high = mid - 1;
            }
        }
        return -1; // Fallback (should not reach)
    }
}