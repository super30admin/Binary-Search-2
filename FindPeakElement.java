// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// We use a binary search approach to find a peak element in the array.
// At each step, we check if the current mid is a peak.
//If not, we move to the side that has a higher value, because a peak is guaranteed to exist in that direction due to the strictly increasing/decreasing condition.

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // Binary search loop
        while (low <= high) {
            // Find mid index
            int mid = low + (high - low) / 2;

            // Check if nums[mid] is a peak
            if ((mid == 0 || nums[mid - 1] < nums[mid])
                    && (mid == n - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // Peak found
            }

            // If the left neighbor is greater, move to the left half
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                // Else move to the right half
                low = mid + 1;
            }
        }

        // Default return
        return 0;
    }
}
