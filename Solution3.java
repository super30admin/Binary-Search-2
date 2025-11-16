// https://leetcode.com/problems/find-peak-element/submissions/1831034181/
// Time complexity: O(logN)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution3 {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if neighbors of mid element are less than mid element.
            // Elements at index 0 and nums.length - 1 have 1 neighbor. They have 0 neighbors if nums.length = 1.
            // All other indices have 2 neighbors.
            if ((mid == 0 || nums[mid - 1] < nums[mid])
                && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Return index
            }
            // Keep moving towards the higher element side
            // until the other neighbor is also less than the higher element
            // or the higher element is at the end of the array.
            if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}