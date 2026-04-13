// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (for no-duplicate version)
// Any problem you faced while coding this : No

/*
Approach:
We use binary search to find the minimum element (pivot) in a rotated sorted array by identifying the unsorted half. 
If the current range is already sorted, we directly return nums[low], otherwise we check if mid is the pivot by comparing neighbors. 
If left half is sorted, we move right; otherwise, we move left to continue searching for the minimum.
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // If already sorted, the smallest element is at low
            if (nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            // Check if mid is the minimum (pivot)
            if ((mid == 0 || nums[mid] < nums[mid - 1]) &&
                (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }

            // Left half is sorted → pivot must be in right half
            else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            }

            // Right half is sorted → pivot must be in left half
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}